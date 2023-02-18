package dev.dineshktech.app.starter.data.repository

import dev.dineshktech.app.starter.core.model.data.Note
import dev.dineshktech.app.starter.database.dao.NotesyDao
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class OfflineFirstNotesRepository @Inject constructor(
    private val notesyDao: NotesyDao,
) : NotesRepository {
    override suspend fun getNotesStream(): Flow<List<Note>> {
        TODO("Not yet implemented")
    }

    override suspend fun getNote(id: Int): Flow<Note> {
        TODO("Not yet implemented")
    }

    override suspend fun deleteNote(note: Note) {
        notesyDao.deleteNotes(arrayListOf(note.id))
    }

    override suspend fun insertNote(note: Note) {
        TODO("Not yet implemented")
    }
}
