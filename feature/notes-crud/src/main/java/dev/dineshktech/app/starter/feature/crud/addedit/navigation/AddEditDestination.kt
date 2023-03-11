package dev.dineshktech.app.starter.feature.crud.addedit.navigation

import androidx.annotation.VisibleForTesting
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import dev.dineshktech.app.starter.feature.crud.addedit.AddEditScreen

const val addEditNoteNavigationRoute = "add_edit_note_route"

@VisibleForTesting
internal const val noteIdArg = "noteId"

fun NavController.navigateToAddEditNote(navOptions: NavOptions? = null) {
    this.navigate("$addEditNoteNavigationRoute/1", navOptions)
}

fun NavGraphBuilder.addEditNoteScreen(onBackClick: (String) -> Unit) {
    composable(
        route = "$addEditNoteNavigationRoute/{$noteIdArg}",
        arguments = listOf(navArgument(noteIdArg) { type = NavType.IntType }),
    ) {
        AddEditScreen(noteId = it.arguments?.getInt(noteIdArg), onBackClick = onBackClick)
    }
}
