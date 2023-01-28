package dev.codewithdk.minimalist.feature.add

import androidx.annotation.VisibleForTesting
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.ExperimentalLifecycleComposeApi

@OptIn(ExperimentalLifecycleComposeApi::class)
@Composable
fun AddNotesRoute(
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: AddNotesViewModel = hiltViewModel(),
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
