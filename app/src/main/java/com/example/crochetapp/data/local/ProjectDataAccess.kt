package com.example.crochetapp.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Update
import androidx.room.Delete
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface ProjectDataAccess {

    //add a new project
    @Insert
    suspend fun insertProject(project: ProjectEntity)

    //get all saved projects
    @Query("SELECT * FROM projects")
    fun getAllProjects(): Flow<List<ProjectEntity>>

    //update an existing project
    @Update
    suspend fun updateProject(project: ProjectEntity)

    //delete a project
    @Delete
    suspend fun deleteProject(project: ProjectEntity)

}