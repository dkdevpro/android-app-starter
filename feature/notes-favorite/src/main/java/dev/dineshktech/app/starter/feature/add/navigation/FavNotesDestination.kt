package dev.dineshktech.app.starter.feature.add.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import dev.dineshktech.app.starter.feature.add.FavNotesScreen

const val favNoteNavigationRoute = "fav_note_route"

fun NavController.navigateToFavNote(navOptions: NavOptions? = null) {
    this.navigate(favNoteNavigationRoute, navOptions)
}

fun NavGraphBuilder.favNoteScreen() {
    composable(route = favNoteNavigationRoute) {
        FavNotesScreen()
    }
}
