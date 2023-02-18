package dev.dineshktech.app.starter.core.model.data

data class Note(
    val id: Int = 0,
    val title: String = "",
    val content: String = "",
    val color: Int = 0,
    val isFavourite: Boolean = false,

)

val previewNotes = listOf(
    Note(
        id = 1,
        title = "Buy groceries",
        content = "Today i should buy 2 kg potatoes and 2kg tomatoes",
        color = 1,
        isFavourite = true,
    ),
    Note(
        id = 2,
        title = "Watch Movie",
        content = "Today i plan to watch holly wood movie",
        color = 1,
        isFavourite = true,
    ),
)
