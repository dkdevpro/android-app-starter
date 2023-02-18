package dev.dineshktech.app.starter.feature.crud.addedit.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import dev.dineshktech.app.starter.feature.crud.addedit.AddEditScreen

const val addEditNoteNavigationRoute = "add_edit_note_route"

fun NavController.navigateToAddEditNote(navOptions: NavOptions? = null) {
    this.navigate(addEditNoteNavigationRoute, navOptions)
}

fun NavGraphBuilder.addEditNoteScreen() {
    composable(route = addEditNoteNavigationRoute) {
        AddEditScreen()
    }
}
