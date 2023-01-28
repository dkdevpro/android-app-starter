package dev.codewithdk.minimalist.core.network

import dev.codewithdk.minimalist.core.model.data.Note

interface NetworkDataSource {
    suspend fun getNotes(ids: List<String>? = null): List<Note>
}
