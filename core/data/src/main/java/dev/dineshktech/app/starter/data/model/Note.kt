package dev.dineshktech.app.starter.data.model

import dev.dineshktech.app.starter.core.model.data.Note
import dev.dineshktech.app.starter.database.model.NotesEntity

fun Note.asEntity() = NotesEntity(
    id = id,
    title = title,
    description = description,
)
