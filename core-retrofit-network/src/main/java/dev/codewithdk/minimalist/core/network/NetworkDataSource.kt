package dev.codewithdk.minimalist.core.network

import dev.codewithdk.minimalist.core.network.model.Note

interface NetworkDataSource {
    suspend fun getNotes(ids: List<String>? = null): List<Note>
}
