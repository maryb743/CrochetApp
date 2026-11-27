package com.example.crochetapp.data.remote

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.net.URL
import org.json.JSONArray

class InspirationApi {

    //URL for the crochet inspiration data
    private val url = "https://raw.githubusercontent.com/maryb743/CrochetInspiration/main/inspiration.json"

    //retrieve and convert JSON data into inspiration items
    suspend fun getInspiration(): List<InspirationItem> {

        return withContext(Dispatchers.IO) {

            //retrieve JSON from GitHub
            val json = URL(url).readText()

            //convert text into a JSON array
            val jsonArray = JSONArray(json)

            //create a list to store inspiration items
            val inspirationItems = mutableListOf<InspirationItem>()

            //loop through each item in the JSON array
            for (i in 0 until jsonArray.length()) {

                val item = jsonArray.getJSONObject(i)

                inspirationItems.add(
                    InspirationItem(
                        id = item.getInt("id"),
                        name = item.getString("name"),
                        difficulty = item.getString("difficulty"),
                        description = item.getString("description")
                    )
                )
            }

            inspirationItems
        }
    }
}