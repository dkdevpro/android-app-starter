package dev.dineshktech.app.starter.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Update
import dev.dineshktech.app.starter.database.model.NotesyEntity
import dev.dineshktech.app.starter.database.upsert
import kotlinx.coroutines.flow.Flow

@Dao
interface NotesyDao {
    @Query(
        value = """
        SELECT * FROM notesy
        WHERE id = :id
    """,
    )
    fun getNote(id: Int): Flow<NotesyEntity>

    @Query(value = "SELECT * FROM notesy")
    fun getNoteEntitiesStream(): Flow<List<NotesyEntity>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertOrIgnoreNotes(noteEntities: List<NotesyEntity>): List<Long>

    @Update
    suspend fun updateNotes(entities: List<NotesyEntity>)

    @Transaction
    suspend fun upsertNotes(entities: List<NotesyEntity>) = upsert(
        items = entities,
        insertMany = ::insertOrIgnoreNotes,
        updateMany = ::updateNotes,
    )

    @Query(
        value = """
            DELETE FROM notesy
            WHERE id in (:ids)
        """,
    )
    suspend fun deleteNotes(ids: List<Int>)
}
