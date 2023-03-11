package dev.dineshktech.app.starter.core.domain

import dev.dineshktech.app.starter.core.model.data.Note
import dev.dineshktech.app.starter.data.model.InvalidNoteException
import dev.dineshktech.app.starter.data.repository.NotesRepository
import javax.inject.Inject

class UpsertNotesUseCase @Inject constructor(
    private val notesRepository: NotesRepository,
) {
    suspend operator fun invoke(note: Note) {
        if (note.title.isNotBlank() || note.content.isNotBlank()) {
            notesRepository.upsertNote(note)
        } else if (note.title.isBlank()) {
            throw InvalidNoteException("title can't be empty")
        } else if (note.content.isBlank()) {
            throw InvalidNoteException("content can't be empty")
        }
    }
}
