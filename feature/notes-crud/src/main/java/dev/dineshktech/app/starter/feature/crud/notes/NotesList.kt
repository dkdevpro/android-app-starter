package dev.dineshktech.app.starter.feature.crud.notes

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.snap
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.gestures.ScrollableDefaults
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridState
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import dev.dineshktech.app.starter.core.model.data.Note

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun NotesList(
    lazyVerticalStaggeredGridState: LazyStaggeredGridState,
    noteList: List<Note>,
) {
    LazyVerticalStaggeredGrid(
        columns = StaggeredGridCells.Fixed(count = 2),
        state = lazyVerticalStaggeredGridState,
        modifier = Modifier
            .fillMaxWidth()
            .padding(all = 8.dp)
            .animateContentSize(
                animationSpec = snap(
                    delayMillis = 100,
                ),
            ),
        flingBehavior = ScrollableDefaults.flingBehavior(),
    ) {
        items(
            items = noteList,
            key = { it.id },
        ) {
            NoteItem(
                modifier = Modifier,
                note = it,
                onClick = {
                    // Handle onclick events
                },
            )
        }
    }
}
