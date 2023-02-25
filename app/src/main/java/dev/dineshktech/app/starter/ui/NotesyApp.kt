package dev.dineshktech.app.starter.ui

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.WindowInsetsSides
import androidx.compose.foundation.layout.consumedWindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.only
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.testTagsAsResourceId
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import dev.dineshktech.app.starter.component.NotesyNavigationBar
import dev.dineshktech.app.starter.component.NotesyNavigationBarItem
import dev.dineshktech.app.starter.icon.AppIcons
import dev.dineshktech.app.starter.navigation.AppNavHost
import dev.dineshktech.app.starter.navigation.NavigationDestination
import dev.dineshktech.app.starter.navigation.ScreenDestination

@OptIn(
    ExperimentalMaterial3Api::class,
    ExperimentalLayoutApi::class,
    ExperimentalComposeUiApi::class,
)
@Composable
fun NotesyApp(
    appState: NotesyAppState = rememberNotesyAppState(),
) {
    NotesyBackground {
        Scaffold(
            modifier = Modifier.semantics {
                testTagsAsResourceId = true
            },
            containerColor = Color.Transparent,
            contentColor = MaterialTheme.colorScheme.onBackground,
            contentWindowInsets = WindowInsets(0, 0, 0, 0),
            floatingActionButtonPosition = FabPosition.End,
            floatingActionButton = {
                val shouldShowFab = appState.topLevelDestinations.any { appState.currentDestination.isTopLevelDestinationInHierarchy(it) }
                AnimatedVisibility(visible = shouldShowFab, enter = fadeIn(), exit = fadeOut()) {
                    FloatingActionButton(onClick = {
                        // Launch add note screen
                        appState.navigateToScreenDestination(ScreenDestination.ADD_EDIT_NOTE)
                    }, shape = CircleShape) {
                        Icon(Icons.Filled.Add, contentDescription = "Add Note")
                    }
                }
            },
            bottomBar = {
                NotesyNavigationBottomBar(
                    destinations = appState.topLevelDestinations,
                    onNavigateToDestination = appState::navigateToNavigationDestination,
                    currentDestination = appState.currentDestination,
                    modifier = Modifier.testTag("NotesyBottomBar"),
                )
            },
        ) { padding ->
            Row(
                Modifier
                    .fillMaxSize()
                    .padding(padding)
                    .consumedWindowInsets(padding)
                    .windowInsetsPadding(
                        WindowInsets.safeDrawing.only(
                            WindowInsetsSides.Horizontal,
                        ),
                    ),
            ) {
                Column(Modifier.fillMaxSize()) {
                    AppNavHost(
                        navController = appState.navController,
                        onBackClick = appState::onBackClick,
                    )
                }
            }
        }
    }
}

/**
 * A navigation bottom bar that draws navigation item
 */
@Composable
private fun NotesyNavigationBottomBar(
    destinations: List<NavigationDestination>,
    onNavigateToDestination: (NavigationDestination) -> Unit,
    currentDestination: NavDestination?,
    modifier: Modifier = Modifier,
) {
    val shouldShowNavigationBar =
        destinations.any { currentDestination.isTopLevelDestinationInHierarchy(it) }
    AnimatedVisibility(visible = shouldShowNavigationBar, enter = fadeIn(), exit = fadeOut()) {
        NotesyNavigationBar(
            modifier = modifier,
        ) {
            destinations.forEach { destination ->
                val selected = currentDestination.isTopLevelDestinationInHierarchy(destination)
                NotesyNavigationBarItem(
                    selected = selected,
                    onClick = { onNavigateToDestination(destination) },
                    icon = {
                        val icon = if (selected) {
                            destination.selectedIcon
                        } else {
                            destination.unselectedIcon
                        }
                        when (icon) {
                            is AppIcons.ImageVectorIcon -> Icon(
                                imageVector = icon.imageVector,
                                contentDescription = null,
                            )

                            is AppIcons.DrawableResourceIcon -> Icon(
                                painter = painterResource(id = icon.id),
                                contentDescription = null,
                            )
                        }
                    },
                    label = { Text(stringResource(destination.iconTextId)) },
                )
            }
        }
    }
}

private fun NavDestination?.isTopLevelDestinationInHierarchy(destination: NavigationDestination) =
    this?.hierarchy?.any {
        it.route?.contains(destination.name, true) ?: false
    } ?: false
