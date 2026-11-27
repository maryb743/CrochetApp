package com.example.crochetapp.data.remote

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.net.URL

class InspirationApi {

    //URL for the crochet inspiration data
    private val url = "https://raw.githubusercontent.com/maryb743/CrochetInspiration/main/inspiration.json"

    //get JSON data from GitHub
    suspend fun getInspiration(): String {

        return withContext(Dispatchers.IO) {

            URL(url).readText()

        }
    }
}