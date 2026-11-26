package com.example.crochetapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.crochetapp.ui.theme.CrochetAppTheme
import com.example.crochetapp.screens.HomeScreen
import com.example.crochetapp.navigation.AppNavigation
import androidx.room.Room
import androidx.activity.viewModels
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.crochetapp.data.local.AppDatabase
import com.example.crochetapp.data.repository.ProjectRepository
import com.example.crochetapp.viewmodel.ProjectViewModel

class MainActivity : ComponentActivity() {

    // Initialise the Room database
    private val database by lazy {
        Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java,
            "crochet_database"
        ).build()
    }

    // Connect the repository to the database
    private val repository by lazy {
        ProjectRepository(database.projectDataAccess())
    }

    // Create the ViewModel
    private val projectViewModel: ProjectViewModel by viewModels {
        viewModelFactory {
            initializer {
                ProjectViewModel(repository)
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            CrochetAppTheme {
                AppNavigation(projectViewModel)
            }
        }
    }
}