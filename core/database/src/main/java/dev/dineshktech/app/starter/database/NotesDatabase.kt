package dev.dineshktech.app.starter.database

import androidx.room.Database
import androidx.room.RoomDatabase
import dev.dineshktech.app.starter.database.dao.NotesyDao
import dev.dineshktech.app.starter.database.model.NotesyEntity

@Database(
    entities = [
        NotesyEntity::class,
    ],
    version = 1,
    exportSchema = true,
)
abstract class NotesDatabase : RoomDatabase() {
    abstract fun notesyDao(): NotesyDao
}
