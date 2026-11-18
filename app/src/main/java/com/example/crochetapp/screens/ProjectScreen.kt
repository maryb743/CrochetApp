package com.example.crochetapp.screens

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
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

import com.example.crochetapp.components.ProjectCard

private val Primula = Color(0xFFEDECC0)
private val Jasmine = Color(0xFFFFFAF4)

@Composable
fun ProjectsScreen(
    onBackClick: () -> Unit = {},
    onAddProject: () -> Unit = {},
    onProjectClick: (String) -> Unit = {}
) {
    var searchText by remember { mutableStateOf("") }

    //temp projects to test
    val projects = listOf(
        "Project 1",
        "Project 2"
    )

    val filteredProjects = projects.filter {
        it.contains(searchText, ignoreCase = true)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Primula)
            .padding(20.dp)
    ) {
        //back + add buttons
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 12.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            IconButton(
                onClick = onBackClick,
                modifier = Modifier
                    .size(40.dp)
                    .background(Jasmine, CircleShape)
            ) {
                Icon(
                    Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = "Back"
                )
            }

            IconButton(
                onClick = onAddProject,
                modifier = Modifier
                    .size(40.dp)
                    .background(Jasmine, CircleShape)
            ) {
                Icon(
                    Icons.Default.Add,
                    contentDescription = "Add project"
                )
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

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

        Spacer(modifier = Modifier.height(28.dp))

        // Two-column project grid
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalArrangement = Arrangement.spacedBy(28.dp),
            modifier = Modifier.fillMaxSize()
        ) {
            items(filteredProjects) { project ->
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
