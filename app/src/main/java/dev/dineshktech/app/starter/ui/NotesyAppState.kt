package dev.dineshktech.app.starter.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.NavDestination
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navOptions
import dev.dineshktech.app.starter.feature.add.navigation.favNoteNavigationRoute
import dev.dineshktech.app.starter.feature.add.navigation.navigateToFavNote
import dev.dineshktech.app.starter.feature.crud.notes.navigation.navigateToNotes
import dev.dineshktech.app.starter.feature.crud.notes.navigation.notesNavigationRoute
import dev.dineshktech.app.starter.navigation.TopLevelDestination
import kotlinx.coroutines.CoroutineScope

@Composable
fun rememberNotesyAppState(
    coroutineScope: CoroutineScope = rememberCoroutineScope(),
    navController: NavHostController = rememberNavController(),
): NotesyAppState {
    return remember(navController, coroutineScope) {
        NotesyAppState(navController)
    }
}

@Stable
class NotesyAppState(
    val navController: NavHostController,
) {
    val currentDestination: NavDestination?
        @Composable get() = navController
            .currentBackStackEntryAsState().value?.destination

    val currentTopLevelDestination: TopLevelDestination?
        @Composable get() = when (currentDestination?.route) {
            notesNavigationRoute -> TopLevelDestination.NOTES
            favNoteNavigationRoute -> TopLevelDestination.FAV_NOTE
            else -> null
        }

    val topLevelDestinations: List<TopLevelDestination> = TopLevelDestination.values().asList()

    fun navigateToTopLevelDestination(topLevelDestination: TopLevelDestination) {
        val topLevelNavOptions = navOptions {
            // Pop up to the start destination of the graph to
            // avoid building up a large stack of destinations
            // on the back stack as users select items
            popUpTo(navController.graph.findStartDestination().id) {
                saveState = true
            }
            // Avoid multiple copies of the same destination when
            // reselecting the same item
            launchSingleTop = true
            // Restore state when reselecting a previously selected item
            restoreState = true
        }

        when (topLevelDestination) {
            TopLevelDestination.NOTES -> navController.navigateToNotes(topLevelNavOptions)
            TopLevelDestination.FAV_NOTE -> navController.navigateToFavNote(topLevelNavOptions)
        }
    }

    fun onBackClick() {
        navController.popBackStack()
    }
}
