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
import dev.dineshktech.app.starter.feature.crud.addedit.navigation.navigateToAddEditNote
import dev.dineshktech.app.starter.feature.crud.notes.navigation.navigateToNotes
import dev.dineshktech.app.starter.feature.crud.notes.navigation.notesNavigationRoute
import dev.dineshktech.app.starter.navigation.NavigationDestination
import dev.dineshktech.app.starter.navigation.ScreenDestination
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

    val currentTopLevelDestination: NavigationDestination?
        @Composable get() = when (currentDestination?.route) {
            notesNavigationRoute -> NavigationDestination.NOTES
            favNoteNavigationRoute -> NavigationDestination.FAV_NOTE
            else -> null
        }

    val topLevelDestinations: List<NavigationDestination> = NavigationDestination.values().asList()

    fun navigateToScreenDestination(screenDestination: ScreenDestination) {
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

        when (screenDestination) {
            ScreenDestination.ADD_EDIT_NOTE -> navController.navigateToAddEditNote(topLevelNavOptions)
        }
    }

    fun navigateToNavigationDestination(topLevelDestination: NavigationDestination) {
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
            NavigationDestination.NOTES -> navController.navigateToNotes(topLevelNavOptions)
            NavigationDestination.FAV_NOTE -> navController.navigateToFavNote(topLevelNavOptions)
        }
    }

    fun onBackClick() {
        navController.popBackStack()
    }
}
