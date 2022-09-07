package dev.codewithdk.minimalist.core.data.model

import dev.codewithdk.minimalist.core.database.dao.model.NotesEntity
import dev.codewithdk.minimalist.core.network.model.Note

fun Note.asEntity() = NotesEntity(
    id = id,
    title = title,
    description = description
)
