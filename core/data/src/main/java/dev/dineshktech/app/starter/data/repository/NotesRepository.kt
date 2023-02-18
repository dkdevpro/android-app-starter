package dev.dineshktech.app.starter.data.repository

import dev.dineshktech.app.starter.core.model.data.Note
import kotlinx.coroutines.flow.Flow

interface NotesRepository {
    suspend fun getNotesStream(): Flow<List<Note>>
    suspend fun getNote(id: Int): Flow<Note>
    suspend fun deleteNote(note: Note)
    suspend fun insertNote(note: Note)
}
