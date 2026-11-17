package com.example.crochetapp.navigation

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.List
import androidx.compose.material.icons.outlined.MenuBook
import androidx.compose.material.icons.outlined.PersonOutline
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

private val Jasmine = Color(0xFFFFFAF4)
private val Willow = Color(0xFFB7B15A)

@Composable
fun NavBar(
    currentRoute: String?,
    onNavigate: (String) -> Unit
) {
    val items = listOf(
        Triple("home", "Home", Icons.Outlined.Home),
        Triple("projects", "Projects", Icons.Outlined.List),
        Triple("inspiration", "Inspiration", Icons.Outlined.MenuBook),
        Triple("profile", "Profile", Icons.Outlined.PersonOutline)
    )

    NavigationBar(
        modifier = Modifier.fillMaxWidth(),
        containerColor = Jasmine
    ) {
        items.forEach { (route, label, icon) ->
            NavigationBarItem(
                selected = currentRoute == route,
                onClick = { onNavigate(route) },
                icon = {
                    Icon(
                        imageVector = icon,
                        contentDescription = label
                    )
                },
                label = { Text(label) },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = Color.Black,
                    selectedTextColor = Color.Black,
                    indicatorColor = Willow,
                    unselectedIconColor = Color.DarkGray,
                    unselectedTextColor = Color.DarkGray
                )
            )
        }
    }
}
