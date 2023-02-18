package dev.dineshktech.app.starter.feature.add

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FavNoteViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
) : ViewModel()
