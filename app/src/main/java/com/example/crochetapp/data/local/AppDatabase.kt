package com.example.crochetapp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

//database for the crochet app
@Database(

    entities = [ProjectEntity::class],
    version = 1,
    exportSchema = false

)
abstract class AppDatabase : RoomDatabase() {

    abstract fun projectDataAccess(): ProjectDataAccess

}
