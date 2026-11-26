package com.example.crochetapp.data.repository

import com.example.crochetapp.data.local.ProjectDataAccess
import com.example.crochetapp.data.local.ProjectEntity

class ProjectRepository(private val projectDataAccess: ProjectDataAccess) {

    //get all saved projects
    val allProjects = projectDataAccess.getAllProjects()

    //add a new project
    suspend fun insertProject(project: ProjectEntity) {

        projectDataAccess.insertProject(project)

    }

    //update an existing project
    suspend fun updateProject(project: ProjectEntity) {

        projectDataAccess.updateProject(project)

    }

    //delete a project
    suspend fun deleteProject(project: ProjectEntity) {

        projectDataAccess.deleteProject(project)

    }
}