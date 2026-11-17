package com.example.crochetapp.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.crochetapp.screens.HomeScreen
import com.example.crochetapp.screens.ProjectsScreen
import com.example.crochetapp.screens.InspirationScreen
import com.example.crochetapp.screens.ProfileScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    val currentEntry = navController.currentBackStackEntryAsState()
    val currentRoute = currentEntry.value?.destination?.route

    //making the bottom nav bar visable and display selected screen
    Scaffold(
        bottomBar = {
            NavBar(

                currentRoute = currentRoute,
                onNavigate = { route ->
                    navController.navigate(route) {
                        popUpTo("home") {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true

                    }
                }
            )
        }
    ) { innerPadding ->

        NavHost(
            navController = navController,
            startDestination = "home",
            modifier = Modifier.padding(innerPadding)
        ) {
            composable("home") {
                HomeScreen()
            }

            composable("projects") {
                ProjectsScreen()
            }

            composable("inspiration") {
                InspirationScreen()
            }

            composable("profile") {
                ProfileScreen()
            }
        }
    }
}
