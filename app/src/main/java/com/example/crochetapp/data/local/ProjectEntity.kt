package com.example.crochetapp.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

//db table for storing crochet projects
@Entity(tableName = "projects")
data class ProjectEntity(

    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,

    val name: String,
    val description: String,
    val yarn: String,
    val hookSize: String,
    val status: String
)