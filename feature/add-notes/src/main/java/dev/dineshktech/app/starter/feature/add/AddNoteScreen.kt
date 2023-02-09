package dev.dineshktech.app.starter.feature.add

import androidx.annotation.VisibleForTesting
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun AddNoteRoute(
    modifier: Modifier = Modifier,
    viewModel: AddNoteViewModel = hiltViewModel(),
) {
    AddNotesScreen(
        modifier = modifier,
    )
}

@VisibleForTesting
@Composable
internal fun AddNotesScreen(
    modifier: Modifier = Modifier,
) {
}
