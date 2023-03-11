package dev.dineshktech.app.starter.feature.crud.notes

import dev.dineshktech.app.starter.core.model.data.Note
import dev.dineshktech.app.starter.data.utils.NotesOrder

sealed class NotesEvent {
    data class Order(val noteOrder: NotesOrder) : NotesEvent()
    data class DeleteNote(val note: Note) : NotesEvent()
    data class AddEditNote(val note: Note) : NotesEvent()
}
