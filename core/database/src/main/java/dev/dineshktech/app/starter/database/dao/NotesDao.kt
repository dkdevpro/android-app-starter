package dev.dineshktech.app.starter.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Update
import dev.dineshktech.app.starter.database.model.NotesEntity
import dev.dineshktech.app.starter.database.upsert
import kotlinx.coroutines.flow.Flow

@Dao
interface NotesDao {
    @Query(
        value = """
        SELECT * FROM notes
        WHERE id = :notesId
    """,
    )
    fun getNotes(notesId: String): Flow<NotesEntity>

    @Query(value = "SELECT * FROM notes")
    fun getNoteEntitiesStream(): Flow<List<NotesEntity>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertOrIgnoreNotes(noteEntities: List<NotesEntity>): List<Long>

    @Update
    suspend fun updateNotes(entities: List<NotesEntity>)

    @Transaction
    suspend fun upsertNotes(entities: List<NotesEntity>) = upsert(
        items = entities,
        insertMany = ::insertOrIgnoreNotes,
        updateMany = ::updateNotes,
    )

    @Query(
        value = """
            DELETE FROM notes
            WHERE id in (:ids)
        """,
    )
    suspend fun deleteNotes(ids: List<String>)
}
