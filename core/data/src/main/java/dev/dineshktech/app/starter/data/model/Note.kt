package dev.dineshktech.app.starter.data.model

import dev.dineshktech.app.starter.core.model.data.Note
import dev.dineshktech.app.starter.database.model.NotesyEntity

fun Note.asEntity() = NotesyEntity(
    id = id,
    title = title,
    content = content,
)
