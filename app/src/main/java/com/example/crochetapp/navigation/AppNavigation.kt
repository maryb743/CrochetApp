package com.example.crochetapp.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
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
    val currentEntry by navController.currentBackStackEntryAsState()
    val currentRoute = currentEntry?.destination?.route

    //display bottom navigation and selected screen
    Scaffold(
        bottomBar = {
            NavBar(
                currentRoute = currentRoute,
                onNavigate = { route ->
                    if (currentRoute != route) {
                        navController.navigate(route) {
                            launchSingleTop = true
                        }
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
                HomeScreen(
                    onProfileClick = {
                        navController.navigate("profile") {
                            launchSingleTop = true
                        }
                    }
                )
            }

            composable("projects") {
                ProjectsScreen(
                    onBackClick = {
                        navController.navigate("home") {
                            popUpTo("home") {
                                inclusive = false
                            }
                            launchSingleTop = true
                        }
                    }
                )
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
