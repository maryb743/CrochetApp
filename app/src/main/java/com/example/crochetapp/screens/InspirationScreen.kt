package com.example.crochetapp.screens

//imports
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import com.example.crochetapp.viewmodel.InspirationViewModel
import com.example.crochetapp.data.remote.InspirationApi
import com.example.crochetapp.data.repository.InspirationRepository
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.crochetapp.ui.theme.Jasmine
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.graphics.Color
import com.example.crochetapp.ui.theme.Cornflower
import com.example.crochetapp.ui.theme.Iris


@Composable
fun InspirationScreen() {

    //creates the ViewModel for the inspiration screen
    val inspirationViewModel: InspirationViewModel = viewModel {
        InspirationViewModel(
            InspirationRepository(
                InspirationApi()
            )
        )
    }

//get inspiration data from the ViewModel
    val inspirationItems by inspirationViewModel.inspirationItems

//tracks loading and network errors
    val isLoading by inspirationViewModel.isLoading
    val errorMessage by inspirationViewModel.errorMessage

    var searchText by rememberSaveable {
        mutableStateOf("")
    }

    //filters inspiration based on the users search
    val searchedInspiration = inspirationItems.filter {

        it.name.contains(searchText, ignoreCase = true)

    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Cornflower)
            .padding(20.dp)
    ) {


        Spacer(modifier = Modifier.height(24.dp))

//search bar
        OutlinedTextField(
            value = searchText,
            onValueChange = { searchText = it },
            modifier = Modifier.fillMaxWidth(),
            placeholder = {
                Text("Search for inspiration...")
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
                focusedContainerColor = Iris,
                unfocusedContainerColor = Iris,
                focusedBorderColor = Color.Transparent,
                unfocusedBorderColor = Color.Transparent

            )
        )

        Spacer(modifier = Modifier.height(28.dp))

        //display loading indicator while retrieving data
        if (isLoading) {

            CircularProgressIndicator(color = Iris)

        } else if (errorMessage.isNotEmpty()) {

            //display an error if the network request fails
            Text(errorMessage)

            Button(
                onClick = {
                    inspirationViewModel.loadInspiration()
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Iris
                )
            ) {
                Text("Try again")
            }

        } else {

            //display downloaded inspiration in a two-column grid
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {

                items(searchedInspiration, key = { it.id }) { item ->

                    Card(
                        colors = CardDefaults.cardColors(
                            containerColor = Jasmine
                        )
                    ) {

                        Column(
                            modifier = Modifier.padding(16.dp)
                        ) {

                            Text(
                                text = item.name,
                                fontSize = 18.sp
                            )

                            Spacer(modifier = Modifier.height(8.dp))

                            Text(text = item.difficulty)

                            Spacer(modifier = Modifier.height(8.dp))

                            Text(text = item.description)
                        }
                    }
                }
            }
        }
    }
}