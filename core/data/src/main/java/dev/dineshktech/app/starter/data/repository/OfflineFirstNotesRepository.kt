package dev.dineshktech.app.starter.data.repository

import dev.dineshktech.app.starter.core.model.data.Note
import dev.dineshktech.app.starter.data.model.asExternalModel
import dev.dineshktech.app.starter.database.dao.NotesyDao
import dev.dineshktech.app.starter.database.model.NotesyEntity
import dev.dineshktech.app.starter.database.model.asExternalModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class OfflineFirstNotesRepository @Inject constructor(
    private val notesyDao: NotesyDao,
) : NotesRepository {
    override fun getNotesStream(): Flow<List<Note>> {
        return notesyDao.getNoteEntitiesStream().map {
            it.map(NotesyEntity::asExternalModel)
        }
    }

    override fun getNote(id: Int): Flow<Note> {
        return notesyDao.getNote(id).map { it.asExternalModel() }
    }

    override suspend fun deleteNote(note: Note) {
        notesyDao.deleteNotes(arrayListOf(note.id))
    }

    override suspend fun upsertNote(note: Note) {
        notesyDao.upsertNotes(arrayListOf(note.asExternalModel()))
    }
}
