package dev.codewithdk.minimalist.feature.add

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AddNotesViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
) : ViewModel() {
}
