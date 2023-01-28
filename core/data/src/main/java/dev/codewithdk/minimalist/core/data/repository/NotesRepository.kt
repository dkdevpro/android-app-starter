package dev.codewithdk.minimalist.core.data.repository

import dev.codewithdk.minimalist.core.model.data.Note
import kotlinx.coroutines.flow.Flow

interface NotesRepository  {
    fun getNotesStream(): Flow<List<Note>>
    fun getNote(id: String): Flow<Note>
}
