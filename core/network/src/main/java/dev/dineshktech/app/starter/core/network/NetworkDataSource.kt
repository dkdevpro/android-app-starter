package dev.dineshktech.app.starter.core.network

import dev.dineshktech.app.starter.core.model.data.Note

interface NetworkDataSource {
    suspend fun getNotes(ids: List<String>? = null): List<Note>
}
