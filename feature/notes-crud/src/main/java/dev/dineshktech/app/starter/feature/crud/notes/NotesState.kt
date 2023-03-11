package dev.dineshktech.app.starter.feature.crud.notes

import dev.dineshktech.app.starter.core.model.data.Note
import dev.dineshktech.app.starter.data.utils.NotesOrder
import dev.dineshktech.app.starter.data.utils.OrderType

data class NotesState(
    var notes: List<Note> = emptyList(),
    val noteOrder: NotesOrder = NotesOrder.Date(OrderType.Descending),
    val isOrderSectionVisible: Boolean = false,
    val isNotesListEmpty: Boolean = false,
)
