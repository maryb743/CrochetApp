package com.example.crochetapp.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.List
import androidx.compose.material.icons.outlined.MenuBook
import androidx.compose.material.icons.outlined.PersonOutline
import androidx.compose.ui.graphics.vector.ImageVector

enum class AppDestinations(
    val label: String,
    val icon: ImageVector
) {
    //labels for each screen
    HOME("Home", Icons.Outlined.Home),
    PROJECTS("My Projects", Icons.Outlined.List),
    INSPIRATION("Inspiration", Icons.Outlined.MenuBook),
    PROFILE("Profile", Icons.Outlined.PersonOutline)
}
