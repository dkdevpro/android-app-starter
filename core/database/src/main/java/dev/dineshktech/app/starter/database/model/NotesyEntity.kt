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
)

fun NotesyEntity.asExternalModel() = Note(
    id = id,
    title = title,
    content = content,
    color = 1,
    isFavourite = true,
)
