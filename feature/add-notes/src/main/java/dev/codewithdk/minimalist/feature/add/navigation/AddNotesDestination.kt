package dev.codewithdk.minimalist.feature.add.navigation

import android.net.Uri
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import dev.codewithdk.minimalist.core.navigation.NavigationDestination
import dev.codewithdk.minimalist.feature.add.AddNotesRoute

object AddNotesDestination : NavigationDestination {
    const val arguments = "arguments"
    override val route = "add_notes/{$arguments}"
    override val destination = "add_notes_destination"

    fun createNavigationRoute(notesIdArg: String): String {
        val encodedId = Uri.encode(notesIdArg)
        return "add_notes_route/$encodedId"
    }

    fun fromNavArgs(entry: NavBackStackEntry): String {
        val encodedId = entry.arguments?.getString(arguments)!!
        return encodedId
    }
}

fun NavGraphBuilder.addNotesGraph(
    onBackClick: () -> Unit
) {
    composable(
        route = AddNotesDestination.route,
        arguments = listOf(
            navArgument(AddNotesDestination.arguments) { type = NavType.StringType }
        )
    ) {
        AddNotesRoute(onBackClick = onBackClick)
    }
}
