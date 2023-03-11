package dev.dineshktech.app.starter.feature.crud.notes

import androidx.annotation.VisibleForTesting
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.staggeredgrid.rememberLazyStaggeredGridState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.ExperimentalLifecycleComposeApi
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import dev.dineshktech.app.starter.core.model.data.Note
import dev.dineshktech.app.starter.feature.notes.R

@OptIn(ExperimentalLifecycleComposeApi::class)
@Composable
fun NotesScreen(
    modifier: Modifier = Modifier,
    viewModel: NotesViewModel = hiltViewModel(),
) {
    val notesState by viewModel.getNotesUiState.collectAsStateWithLifecycle()
    NotesScreen(
        notesState = notesState,
        modifier = modifier,
    )
}

@OptIn(ExperimentalFoundationApi::class)
@VisibleForTesting
@Composable
internal fun NotesScreen(
    notesState: NotesUiState,
    modifier: Modifier = Modifier,
) {
    val lazyVerticalStaggeredGridState = rememberLazyStaggeredGridState()
    when (notesState) {
        NotesUiState.Loading -> {
            // Add loading state
        }
        is NotesUiState.Success -> {
            // Add success and non-zero count
            NotesList(
                lazyVerticalStaggeredGridState = lazyVerticalStaggeredGridState,
                noteList = notesState.notes,
            )
        }
    }
    Column(
        modifier = modifier
            .padding(16.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = stringResource(id = R.string.notes_empty_error),
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold,
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = stringResource(id = R.string.notes_empty_description),
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.bodyMedium,
        )
    }
}

sealed interface NotesUiState {
    object Loading : NotesUiState
    data class Success(
        val notes: List<Note>,
    ) : NotesUiState
}
