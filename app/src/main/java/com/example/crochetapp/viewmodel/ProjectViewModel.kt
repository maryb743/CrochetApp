package com.example.crochetapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.crochetapp.data.local.ProjectEntity
import com.example.crochetapp.data.repository.ProjectRepository
import kotlinx.coroutines.launch

class ProjectViewModel(private val repository: ProjectRepository) : ViewModel() {

    //get all saved projects
    val allProjects = repository.allProjects

    //add a new project
    fun insertProject(project: ProjectEntity) {

        viewModelScope.launch {

            repository.insertProject(project)

        }

    }

    //update an existing project
    fun updateProject(project: ProjectEntity) {

        viewModelScope.launch {

            repository.updateProject(project)

        }

    }

    //delete a project
    fun deleteProject(project: ProjectEntity) {

        viewModelScope.launch {

            repository.deleteProject(project)

        }

    }

}