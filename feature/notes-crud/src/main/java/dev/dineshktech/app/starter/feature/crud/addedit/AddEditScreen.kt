package dev.dineshktech.app.starter.feature.crud.addedit

import androidx.annotation.VisibleForTesting
import androidx.compose.animation.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.TaskAlt
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import kotlinx.coroutines.launch

val RedOrange = Color(0xFFFF9E80)
val Violet = Color(0xFFEA80FC)
val BabyBlue = Color(0xFFB388FF)
val RedPink = Color(0xFFFF80AB)
val noteColors =
    listOf(DefaultColor, BlueColor, RedOrange, Violet, BabyBlue, RedPink)

@Composable
fun AddEditScreen(
    modifier: Modifier = Modifier,
    viewModel: AddEditNoteViewModel = hiltViewModel(),
) {
    AddEditScreen(
        modifier = modifier,
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@VisibleForTesting
@Composable
internal fun AddEditScreen(
    modifier: Modifier = Modifier,
) {
    val noteBackgroundAnimatable = remember {
        Animatable(
            Color(RedOrange.value),
        )
    }
    val scope = rememberCoroutineScope()
    val systemUiController = rememberSystemUiController()
    val useDarkIcons = !isSystemInDarkTheme()

    DisposableEffect(systemUiController, useDarkIcons) {
        // Update all of the system bar colors to be transparent, and use
        // dark icons if we're in light theme
        systemUiController.setSystemBarsColor(
            color = Color.Transparent,
            darkIcons = useDarkIcons,
            isNavigationBarContrastEnforced = false,
        )
        onDispose { }
    }

    Scaffold(
        topBar = {
            AddEditScreenTopAppBar(
                onBackClicked = {
                    // handle onback click
                },
                onNoteSaved = {
                    // OnNoteSaved
                },
            )
        },
    ) { padding ->
        NoteEditor(padding, noteBackgroundAnimatable.value) {
            scope.launch {
                noteBackgroundAnimatable.animateTo(
                    targetValue = Color(it),
                    animationSpec = tween(
                        durationMillis = 500,
                    ),
                )
            }
        }
    }
}

@Composable
fun NoteEditor(padding: PaddingValues, color: Color, onColorPicked: (Int) -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(padding)
            .background(color)
            .padding(16.dp),
    ) {
        NoteColorPicker(
            onColorPicked = { colorInt ->
                onColorPicked(colorInt)
            },
        )

        Spacer(modifier = Modifier.height(10.dp))

        NotesyAddEditTextField(
            text = "",
            hint = "Title",
            onValueChange = {
                // onValueChange -recomposition required
            },
            singleLine = true,
            textStyle = MaterialTheme.typography.bodyLarge,
            fontSize = 25.sp,
            requestFocus = true,
            textSelectionColor = if (color == BlueColor) BrownColor else BlueColor,
            noteBackgroundColor = color,
        )

        Spacer(modifier = Modifier.height(16.dp))

        NotesyAddEditTextField(
            modifier = Modifier
                .fillMaxHeight(),
            text = "",
            hint = "Add notes in detail",
            onValueChange = {
                // onValueChange - recomposition required
            },
            singleLine = false,
            textStyle = MaterialTheme.typography.bodyMedium,
            fontSize = 16.sp,
            textSelectionColor = if (color == BlueColor) BrownColor else BlueColor,
            noteBackgroundColor = color,
        )
    }
}

@Composable
fun NoteColorPicker(
    onColorPicked: (Int) -> Unit,
) {
    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        items(items = noteColors) { color ->
            val colorInt = color.toArgb()
            Box(
                modifier = Modifier
                    .size(30.dp)
                    .shadow(
                        elevation = 10.dp,
                        shape = CircleShape,
                    )
                    .clip(CircleShape)
                    .background(color)
                    .border(
                        width = 2.dp,
                        // color = if (viewModel.noteColor.value == colorInt) Color.White else Color.Transparent,
                        color = Color.White,
                        shape = CircleShape,
                    )
                    .clickable {
                        onColorPicked(colorInt)
                        // OnColor change to be broadcast-ed.
                    },
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddEditScreenTopAppBar(
    onBackClicked: () -> Unit,
    onNoteSaved: () -> Unit,
) {
    TopAppBar(
        title = { Text("Add Note") },
        navigationIcon = {
            IconButton(
                onClick = { onBackClicked() },
                modifier = Modifier
                    .clip(CircleShape)
                    .background(MaterialTheme.colorScheme.surface),
            ) {
                Icon(
                    Icons.Default.ArrowBack,
                    contentDescription = "Back arrow",
                    tint = MaterialTheme.colorScheme.outline,
                )
            }
        },
        actions = {
            IconButton(
                onClick = { onNoteSaved() },
                modifier = Modifier
                    .clip(CircleShape)
                    .background(MaterialTheme.colorScheme.surface),
            ) {
                Icon(
                    imageVector = Icons.Default.TaskAlt,
                    contentDescription = "Save note",
                    tint = MaterialTheme.colorScheme.outline,
                )
            }
        },
    )
}
