package dev.dineshktech.app.starter.feature.add.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable

const val addNoteNavigationRoute = "add_notes_route"

fun NavController.navigateToAddNote(navOptions: NavOptions? = null) {
    this.navigate(addNoteNavigationRoute, navOptions)
}

fun NavGraphBuilder.addNoteScreen() {
    composable(route = addNoteNavigationRoute) {
    }
}
