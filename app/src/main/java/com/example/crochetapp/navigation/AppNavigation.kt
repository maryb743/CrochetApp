package com.example.crochetapp.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItemColors
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteScaffold
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteDefaults
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.example.crochetapp.screens.HomeScreen
import com.example.crochetapp.screens.ProjectsScreen
import com.example.crochetapp.screens.InspirationScreen
import com.example.crochetapp.screens.ProfileScreen
//colour imports
import com.example.crochetapp.ui.theme.Jasmine
import com.example.crochetapp.ui.theme.TeaRose
import com.example.crochetapp.ui.theme.Oleander
import com.example.crochetapp.ui.theme.Willow
import com.example.crochetapp.ui.theme.Primula

@Composable
fun AppNavigation(projectViewModel: ProjectViewModel) {

    //current screen
    var currentDestination by rememberSaveable {

        mutableStateOf(AppDestinations.HOME)

    }


//changes the selected navbar colour depending on the current screen
    val selectedNavColor = when (currentDestination) {

        AppDestinations.HOME -> Oleander
        AppDestinations.PROJECTS -> Willow
        else -> Willow

    }

//applies the colour (only works on home and projects so far)
    val navItemColors = NavigationSuiteDefaults.itemColors(

        navigationBarItemColors = NavigationBarItemDefaults.colors(
            selectedIconColor = selectedNavColor,
            selectedTextColor = selectedNavColor,
            indicatorColor = Jasmine

        )
    )

    //nav bar that ajusts to screen size
    NavigationSuiteScaffold(
        navigationSuiteItems = {

            //loop to go through diff screens available
            AppDestinations.entries.forEach { destination ->
                item(

                    icon = {

                        //label for each sreen
                        Icon(

                            imageVector = destination.icon,
                            contentDescription = destination.label

                        )
                    },

                    label = {

                        Text(destination.label)

                    },

                    //highlights select screen
                    selected = currentDestination == destination,

                    //when clicked screen updates
                    onClick = {

                        currentDestination = destination
                    },

                    colors = navItemColors
                )
            }
        },

        navigationSuiteColors = NavigationSuiteDefaults.colors(
            navigationBarContainerColor = Jasmine,
            navigationRailContainerColor = Jasmine

        )
    ) {
        Scaffold(
            modifier = Modifier.fillMaxSize()
        ) { innerPadding ->

            val screenModifier = Modifier.padding(innerPadding)


            //displays composoble matching selected screen
            when (currentDestination) {

                //home screen
                AppDestinations.HOME -> HomeScreen(
                    //when profile is clicked go to profiel
                    onProfileClick = {
                        currentDestination = AppDestinations.PROFILE
                    },

                    //when new project is clicked go to project
                    onNewProject = {
                        currentDestination = AppDestinations.PROJECTS
                    }
                )

                //projectscreen
                AppDestinations.PROJECTS -> ProjectsScreen(
                    projectViewModel = projectViewModel,
                    onBackClick = {
                        currentDestination = AppDestinations.HOME
                    }
                )

                //inspo screen(tobeadded)
                AppDestinations.INSPIRATION -> InspirationScreen()

                //profile screen(tbadded)
                AppDestinations.PROFILE -> ProfileScreen()

            }

        }
    }
}


