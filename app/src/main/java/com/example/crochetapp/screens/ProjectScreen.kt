package com.example.crochetapp.screens

//imports
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.crochetapp.components.ProjectCard
import com.example.crochetapp.ui.theme.Jasmine
import com.example.crochetapp.ui.theme.Primula
import com.example.crochetapp.viewmodel.ProjectViewModel
import com.example.crochetapp.components.AddProjectForm
import com.example.crochetapp.data.local.ProjectEntity

@Composable
//navigation, adding new proj and selecting
fun ProjectsScreen(

    projectViewModel: ProjectViewModel,
    onBackClick: () -> Unit = {},
    onAddProject: () -> Unit = {},
    onProjectClick: (String) -> Unit = {}

) {

    //variable to store users search input
    var searchText by rememberSaveable {

        mutableStateOf("")

    }

    //controls whether the add project form is visible
    var showAddProjectForm by rememberSaveable {

        mutableStateOf(false)
    }

    //stores the project selected for editing
    var selectedProject by rememberSaveable {
        mutableStateOf<ProjectEntity?>(null)
    }

    //get saved projects from the database
    val projects by projectViewModel.allProjects.collectAsState(
        initial = emptyList()
    )

    //filters projects based on users searchs
    val searchedProjects = projects.filter {

        it.name.contains(searchText, ignoreCase = true)
    }

    //displays the add project form when the plus button is clicked
    if (showAddProjectForm) {

        AddProjectForm(
            onDismiss = {
                showAddProjectForm = false
            },
            onSave = { project ->
                projectViewModel.insertProject(project)
                showAddProjectForm = false
            }
        )
    }

    //displays the form for editing an existing project
    selectedProject?.let { project ->

        AddProjectForm(
            existingProject = project,

            onDismiss = {
                selectedProject = null
            },

            onSave = { updatedProject ->
                projectViewModel.updateProject(updatedProject)
                selectedProject = null
            }
        )
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

                onClick = {
                    showAddProjectForm = true
                },
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
            items(searchedProjects, key = { it.id }) { project ->
                ProjectCard(
                    projectName = project.name,
                    onDetailsClick = {
                        selectedProject = project
                    }
                )
            }
        }
    }
}
