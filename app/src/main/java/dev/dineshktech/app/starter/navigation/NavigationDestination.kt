package dev.dineshktech.app.starter.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.rounded.Favorite
import androidx.compose.material.icons.rounded.List
import dev.dineshktech.app.starter.icon.AppIcons

enum class NavigationDestination(
    val selectedIcon: AppIcons,
    val unselectedIcon: AppIcons,
    val iconTextId: Int,
) {
    NOTES(
        selectedIcon = AppIcons.ImageVectorIcon(Icons.Filled.List),
        unselectedIcon = AppIcons.ImageVectorIcon(Icons.Rounded.List),
        iconTextId = dev.dineshktech.app.starter.feature.notes.R.string.notes,
    ),
    FAV_NOTE(
        selectedIcon = AppIcons.ImageVectorIcon(Icons.Filled.Favorite),
        unselectedIcon = AppIcons.ImageVectorIcon(Icons.Rounded.Favorite),
        iconTextId = dev.dineshktech.app.starter.feature.add.notes.R.string.fav_notes,
    ),
}
