package dev.dineshktech.app.starter.core.model.data

data class Note(
    val id: Int = 0,
    val title: String = "",
    val content: String = "",
    val timestamp: Long = 0,
    val color: Int = 0,
    val isFavourite: Boolean = false,
)
