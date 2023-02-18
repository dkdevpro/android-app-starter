package dev.dineshktech.app.starter.icon

import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.vector.ImageVector

sealed class AppIcons {
    data class ImageVectorIcon(val imageVector: ImageVector) : AppIcons()
    data class DrawableResourceIcon(@DrawableRes val id: Int) : AppIcons()
}
