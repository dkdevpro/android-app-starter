package dev.codewithdk.minimalist.core.database.dao

import androidx.room.Database
import androidx.room.RoomDatabase
import dev.codewithdk.minimalist.core.database.dao.dao.NotesDao
import dev.codewithdk.minimalist.core.database.dao.model.NotesEntity

@Database(
    entities = [
        NotesEntity::class
    ],
    version = 1,
    exportSchema = true,
)
abstract class NotesDatabase : RoomDatabase() {
    abstract fun noteDao(): NotesDao
}
