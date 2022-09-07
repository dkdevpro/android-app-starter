package dev.codewithdk.minimalist.core.retrofit.network

import dev.codewithdk.minimalist.core.retrofit.network.model.Note

interface NetworkDataSource {
    suspend fun getNotes(ids: List<String>? = null): List<Note>
}
