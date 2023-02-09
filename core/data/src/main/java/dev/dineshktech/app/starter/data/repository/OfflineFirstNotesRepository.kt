package dev.dineshktech.app.starter.data.repository

import dev.dineshktech.app.starter.core.model.data.Note
import dev.dineshktech.app.starter.core.network.NetworkDataSource
import dev.dineshktech.app.starter.database.dao.NotesDao
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class OfflineFirstNotesRepository @Inject constructor(
    private val authorDao: NotesDao,
    private val network: NetworkDataSource,
) : NotesRepository {
    override fun getNotesStream(): Flow<List<Note>> {
        TODO("Not yet implemented")
    }

    override fun getNote(id: String): Flow<Note> {
        TODO("Not yet implemented")
    }
}
