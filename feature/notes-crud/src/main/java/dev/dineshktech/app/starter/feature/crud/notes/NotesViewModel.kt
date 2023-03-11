package dev.dineshktech.app.starter.feature.crud.notes

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.dineshktech.app.starter.core.domain.GetNotesUseCase
import dev.dineshktech.app.starter.core.model.data.Note
import dev.dineshktech.app.starter.data.repository.NotesRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.filterNot
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NotesViewModel @Inject constructor(
    private val notesRepository: NotesRepository,
    getNotesUseCase: GetNotesUseCase,
) : ViewModel() {

    private val _state = mutableStateOf(NotesState())
    val state: State<NotesState> = _state

    val getNotesUiState: StateFlow<NotesUiState> = getNotesUseCase()
        .filterNot { it.isEmpty() }
        .map<List<Note>, NotesUiState>(NotesUiState::Success)
        .onStart { emit(NotesUiState.Loading) }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = NotesUiState.Loading,
        )

    fun onEvent(event: NotesEvent) {
        when (event) {
            is NotesEvent.Order -> {
                if (state.value.noteOrder == event.noteOrder &&
                    state.value.noteOrder.orderType == event.noteOrder.orderType
                ) {
                    return
                }
                // getNotes(noteOrder = event.noteOrder)
            }
            is NotesEvent.DeleteNote -> {
                viewModelScope.launch {
                    notesRepository.deleteNote(event.note)
                }
            }
            is NotesEvent.AddEditNote -> {
                viewModelScope.launch {
                    notesRepository.upsertNote(event.note)
                }
            }
        }
    }

    sealed class UiEvent {
        data class Snackbar(val message: String) : UiEvent()
    }
}
