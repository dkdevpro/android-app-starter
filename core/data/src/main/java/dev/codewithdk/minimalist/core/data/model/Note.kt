package dev.codewithdk.minimalist.core.data.model

import dev.codewithdk.minimalist.core.database.dao.model.NotesEntity
import dev.codewithdk.minimalist.core.model.data.Note

fun Note.asEntity() = NotesEntity(
    id = id,
    title = title,
    description = description
)
