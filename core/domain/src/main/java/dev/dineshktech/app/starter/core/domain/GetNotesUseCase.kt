package dev.dineshktech.app.starter.core.domain

import dev.dineshktech.app.starter.core.domain.utils.NotesOrder
import dev.dineshktech.app.starter.core.domain.utils.OrderType
import dev.dineshktech.app.starter.core.model.data.Note
import dev.dineshktech.app.starter.data.repository.NotesRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GetNotesUseCase @Inject constructor(
    private val notesRepository: NotesRepository,
) {
    suspend operator fun invoke(notesOrder: NotesOrder = NotesOrder.Date(OrderType.Ascending)): Flow<List<Note>> {
        return notesRepository.getNotesStream().map { notes ->
            when (notesOrder.orderType) {
                is OrderType.Ascending -> {
                    when (notesOrder) {
                        is NotesOrder.Title -> notes.sortedBy { it.title.lowercase() }
                        is NotesOrder.Date -> notes.sortedBy { it.timestamp }
                        is NotesOrder.Color -> notes.sortedBy { it.color }
                    }
                }
                is OrderType.Descending -> {
                    when (notesOrder) {
                        is NotesOrder.Title -> notes.sortedByDescending { it.title.lowercase() }
                        is NotesOrder.Date -> notes.sortedByDescending { it.timestamp }
                        is NotesOrder.Color -> notes.sortedByDescending { it.color }
                    }
                }
            }
        }
    }
}
