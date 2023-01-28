package dev.codewithdk.minimalist.core.ktor.network

import dev.codewithdk.minimalist.core.ktor.network.model.Note

interface NetworkDataSource {
    suspend fun getNotes(ids: List<String>? = null): List<Note>
}
