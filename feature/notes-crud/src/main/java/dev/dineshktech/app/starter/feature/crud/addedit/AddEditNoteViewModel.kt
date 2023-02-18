package dev.dineshktech.app.starter.feature.crud.addedit

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.dineshktech.app.starter.core.model.data.Note
import dev.dineshktech.app.starter.data.repository.NotesRepository
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddEditNoteViewModel @Inject constructor(
    private val notesRepository: NotesRepository,
    savedStateHandle: SavedStateHandle,
) : ViewModel() {
    init {
        savedStateHandle.get<Int>("noteId")?.let { noteId ->
            if (noteId != -1) {
                viewModelScope.launch {
                    notesRepository.getNote(noteId).map { note ->
                        currentNoteId = note.id
                    }
                }
            }
        }
    }

    private var currentNoteId: Int? = null

    private val _mutableNoteState = mutableStateOf(Note())
    val notesState: State<Note> = _mutableNoteState

    suspend fun onSaveNote() {
        notesRepository.insertNote(Note(1, "", "", 1, isFavourite = false))
    }

}
