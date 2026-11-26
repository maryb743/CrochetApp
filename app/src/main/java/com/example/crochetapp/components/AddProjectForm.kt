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

    onDismiss: () -> Unit,
    onSave: (ProjectEntity) -> Unit

) {

    // Stores the user's input
    var name by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }
    var yarn by remember { mutableStateOf("") }
    var hookSize by remember { mutableStateOf("") }
    var status by remember { mutableStateOf("In Progress") }

    AlertDialog(

        onDismissRequest = onDismiss,
        containerColor = Jasmine,

        title = {

            Text("New crochet project")

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