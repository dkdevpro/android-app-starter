package dev.codewithdk.minimalist.core.model.data

data class Note(
    val id: String,
    val title: String,
    val description: String
)

val previewNotes = listOf(
    Note(
        id = "1",
        title = "Buy groceries",
        description = "Today i should buy 2 kg potatoes and 2kg tomatoes"
    ),
    Note(
        id = "2",
        title = "Watch Movie",
        description = "Today i plan to watch holly wood movie"
    )
)
