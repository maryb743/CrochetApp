package com.example.crochetapp.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.crochetapp.data.local.ProjectEntity
import com.example.crochetapp.ui.theme.Jasmine
import com.example.crochetapp.ui.theme.Willow

@Composable
fun AddProjectForm(

    existingProject: ProjectEntity? = null,
    onDismiss: () -> Unit,
    onSave: (ProjectEntity) -> Unit

) {

//stores new or existing project details
    var name by remember {
        mutableStateOf(existingProject?.name ?: "")
    }

    var description by remember {
        mutableStateOf(existingProject?.description ?: "")
    }

    var yarn by remember {
        mutableStateOf(existingProject?.yarn ?: "")
    }

    var hookSize by remember {
        mutableStateOf(existingProject?.hookSize ?: "")
    }

    var status by remember {
        mutableStateOf(existingProject?.status ?: "In Progress")
    }

    AlertDialog(

        onDismissRequest = onDismiss,
        containerColor = Jasmine,

        title = {
            Text(
                if (existingProject == null)
                    "New crochet project"
                else
                    "Edit crochet project"
            )
        },
        text = {
            Column(

                modifier = Modifier.verticalScroll(
                    rememberScrollState()

                ),

                verticalArrangement = Arrangement.spacedBy(12.dp)

            ) {

                OutlinedTextField(

                    value = name,
                    onValueChange = { name = it },
                    label = { Text("Project name") }

                )

                OutlinedTextField(

                    value = description,
                    onValueChange = { description = it },
                    label = { Text("Description") }

                )

                OutlinedTextField(

                    value = yarn,
                    onValueChange = { yarn = it },
                    label = { Text("Yarn") }

                )

                OutlinedTextField(

                    value = hookSize,
                    onValueChange = { hookSize = it },
                    label = { Text("Hook size") }

                )

                OutlinedTextField(

                    value = status,
                    onValueChange = { status = it },
                    label = { Text("Status") }

                )
            }
        },

        confirmButton = {

            Button(

                enabled = name.isNotBlank(),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Willow

                ),
                onClick = {

                    onSave(

                        ProjectEntity(

                            id = existingProject?.id ?: 0,
                            name = name.trim(),
                            description = description,
                            yarn = yarn,
                            hookSize = hookSize,
                            status = status

                        )
                    )
                }
            ) {

                Text("Save project")
            }
        },

        dismissButton = {

            TextButton(onClick = onDismiss) {
                Text("Cancel")

            }
        }
    )
}