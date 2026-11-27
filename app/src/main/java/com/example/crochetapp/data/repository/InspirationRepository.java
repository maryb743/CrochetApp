package com.example.crochetapp.data.repository

import com.example.crochetapp.data.remote.InspirationApi
import com.example.crochetapp.data.remote.InspirationItem

class InspirationRepository(private val inspirationApi: InspirationApi) {

    //get crochet inspiration from the online JSON file
    suspend fun getInspiration(): List<InspirationItem> {

        return inspirationApi.getInspiration()

    }
}