package com.google.samples.apps.nowinandroid.core.domain

import dev.dineshktech.app.starter.core.model.data.Note
import dev.dineshktech.app.starter.data.repository.NotesRepository
import javax.inject.Inject

class GetNotesUseCase @Inject constructor(
    private val notesRepository: NotesRepository,
) {
    suspend operator fun invoke(note: Note) {
        notesRepository.insertNote(note)
    }
}
