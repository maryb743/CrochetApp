package com.example.crochetapp.screens

//imports
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.crochetapp.components.ProjectCard

//colour imports
import com.example.crochetapp.ui.theme.Jasmine
import com.example.crochetapp.ui.theme.TeaRose
import com.example.crochetapp.ui.theme.Oleander
import com.example.crochetapp.ui.theme.Willow
import com.example.crochetapp.ui.theme.Primula

@Composable
//navigation, adding new proj and selecting
fun ProjectsScreen(
    onBackClick: () -> Unit = {},
    onAddProject: () -> Unit = {},
    onProjectClick: (String) -> Unit = {}
) {
    //variable to store users search input
    var searchText by rememberSaveable {
        mutableStateOf("")

    }

    //temp projects to test
    val projects = listOf(
        "Project 1",
        "Project 2"
    )
    //filters projects based on users searchs
    val searchedProjects = projects.filter {

        it.contains(searchText, ignoreCase = true)

    }
    //creates vertical screen layout
    Column(

        modifier = Modifier
            .fillMaxSize()
            .background(Primula)
            .padding(20.dp)

    ) {

        //creates horizxontal screen layout
        //back + add buttons
        Row(

            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 12.dp),
            horizontalArrangement = Arrangement.SpaceBetween

        ) {
    //clickable back button
            IconButton(

                onClick = onBackClick,
                modifier = Modifier
                    .size(40.dp)
                    .background(Jasmine, CircleShape)

            ) {
            //automatically reserves arrow for right-toleft languages and contentdescription = back for accesiblity
                Icon(

                    Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = "Back"

                )

            }

            //addproject button
            IconButton(

                onClick = onAddProject,
                modifier = Modifier
                    .size(40.dp)
                    .background(Jasmine, CircleShape)

            ) {
        //displays a plus sign and adds a description for accesibility
                Icon(

                    Icons.Default.Add,
                    contentDescription = "Add project"

                )
            }
        }

        //adds 24dp verticlaly between elements
        Spacer(

            modifier = Modifier.height(24.dp)

        )

        //search bar to search projects
        OutlinedTextField(

            value = searchText,
            onValueChange = { searchText = it },
            modifier = Modifier.fillMaxWidth(),

            placeholder = {

                Text("Search your projects...")

            },

            leadingIcon = {

                Icon(

                    Icons.Default.Search,
                    contentDescription = null

                )

            },

            singleLine = true,
            shape = RoundedCornerShape(14.dp),
            colors = OutlinedTextFieldDefaults.colors(
                focusedContainerColor = Jasmine,
                unfocusedContainerColor = Jasmine,
                focusedBorderColor = Color.Transparent,
                unfocusedBorderColor = Color.Transparent
            )
        )
        //adds 28dp vertically between elements
        Spacer(modifier = Modifier.height(28.dp))

        // Two-column project grid
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalArrangement = Arrangement.spacedBy(28.dp),
            modifier = Modifier.fillMaxSize()
        ) {
            items(searchedProjects) { project ->
                ProjectCard(
                    projectName = project,
                    onDetailsClick = {
                        onProjectClick(project)
                    }
                )
            }
        }
    }
}
