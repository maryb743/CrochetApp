package com.example.crochetapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.compose.runtime.mutableStateOf
import com.example.crochetapp.data.remote.InspirationItem
import com.example.crochetapp.data.repository.InspirationRepository
import kotlinx.coroutines.launch
import kotlinx.coroutines.CancellationException

class InspirationViewModel(
    private val repository: InspirationRepository
) : ViewModel() {

    //stores the inspiration items
    val inspirationItems = mutableStateOf<List<InspirationItem>>(emptyList())

    //tracks whether data is loading
    val isLoading = mutableStateOf(false)

    //stores any network error
    val errorMessage = mutableStateOf("")

    //loads inspiration when the ViewModel is created
    init {
        loadInspiration()
    }

    //retrieve inspiration from the repository
    fun loadInspiration() {

        viewModelScope.launch {

            isLoading.value = true
            errorMessage.value = ""

            try {

                inspirationItems.value = repository.getInspiration()

            } catch (e: CancellationException) {

                throw e

            } catch (e: Exception) {

                errorMessage.value = "Unable to load inspiration"

            } finally {

                isLoading.value = false

            }
        }
    }
}