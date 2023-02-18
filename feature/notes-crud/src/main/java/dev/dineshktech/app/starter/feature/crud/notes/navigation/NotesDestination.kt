package dev.dineshktech.app.starter.feature.crud.notes.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import dev.dineshktech.app.starter.feature.crud.notes.NotesScreen

const val notesNavigationRoute = "notes_route"

fun NavController.navigateToNotes(navOptions: NavOptions? = null) {
    this.navigate(notesNavigationRoute, navOptions)
}

fun NavGraphBuilder.notesScreen() {
    composable(route = notesNavigationRoute) {
        NotesScreen()
    }
}
