package dev.codewithdk.minimalist.core.database.dao.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import dev.codewithdk.minimalist.core.model.data.Note

@Entity(
    tableName = "notes",
)
data class NotesEntity(
    @PrimaryKey
    val id: String,
    val title: String,
    val description: String
)

fun NotesEntity.asExternalModel() = Note(
    id = id,
    title = title,
    description = description
)
