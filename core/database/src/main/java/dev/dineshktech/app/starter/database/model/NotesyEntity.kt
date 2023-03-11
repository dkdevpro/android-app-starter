package dev.dineshktech.app.starter.database.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import dev.dineshktech.app.starter.core.model.data.Note

@Entity(
    tableName = "notesy",
)
data class NotesyEntity(
    @PrimaryKey
    val id: Int,
    val title: String,
    val content: String,
    val timestamp: Long,
    val color: Int,
    val isFavourite: Boolean,
)

fun NotesyEntity.asExternalModel() = Note(
    id = id,
    title = title,
    content = content,
    timestamp = timestamp,
    color = color,
    isFavourite = isFavourite,
)
