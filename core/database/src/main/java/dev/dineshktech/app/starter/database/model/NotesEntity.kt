package dev.dineshktech.app.starter.database.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import dev.dineshktech.app.starter.core.model.data.Note

@Entity(
    tableName = "notes",
)
data class NotesEntity(
    @PrimaryKey
    val id: String,
    val title: String,
    val description: String,
)

fun NotesEntity.asExternalModel() = Note(
    id = id,
    title = title,
    description = description,
)
