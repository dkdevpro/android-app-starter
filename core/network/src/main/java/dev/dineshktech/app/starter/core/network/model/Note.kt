package dev.dineshktech.app.starter.core.network.model

import kotlinx.serialization.Serializable

@Serializable
data class Note(
    val id: String,
    val title: String = "",
    val description: String = "",
)
