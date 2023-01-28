package dev.codewithdk.minimalist.core.data.repository

import dev.codewithdk.minimalist.core.database.dao.dao.NotesDao
import dev.codewithdk.minimalist.core.model.data.Note
import dev.codewithdk.minimalist.core.network.NetworkDataSource
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
