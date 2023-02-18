package dev.dineshktech.app.starter.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import dev.dineshktech.app.starter.feature.add.navigation.favNoteScreen
import dev.dineshktech.app.starter.feature.crud.addedit.navigation.addEditNoteScreen
import dev.dineshktech.app.starter.feature.crud.notes.navigation.notesNavigationRoute
import dev.dineshktech.app.starter.feature.crud.notes.navigation.notesScreen

@Composable
fun AppNavHost(
    navController: NavHostController,
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier,
    startDestination: String = notesNavigationRoute,
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier,
    ) {
        notesScreen()
        favNoteScreen()
        addEditNoteScreen()
    }
}
