package dev.dineshktech.app.starter.database

import androidx.room.Database
import androidx.room.RoomDatabase
import dev.dineshktech.app.starter.database.dao.NotesDao
import dev.dineshktech.app.starter.database.model.NotesEntity

@Database(
    entities = [
        NotesEntity::class,
    ],
    version = 1,
    exportSchema = true,
)
abstract class NotesDatabase : RoomDatabase() {
    abstract fun noteDao(): NotesDao
}
