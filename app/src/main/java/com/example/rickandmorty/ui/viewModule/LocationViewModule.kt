package com.example.rickandmorty.ui.viewModule

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rickandmorty.data.api.RickAndMortyApi
import com.example.rickandmorty.data.model.Location
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class LocationViewModule(private val api: RickAndMortyApi): ViewModel() {

    private val _locations = MutableStateFlow<List<Location>>(emptyList())
    val locations: StateFlow<List<Location>> = _locations

    private val _isLoading = MutableStateFlow(true)
    val isLoading: StateFlow<Boolean> = _isLoading

    init {
        fetchAllLocations()
    }

    private fun fetchAllLocations() {
        viewModelScope.launch {
            try {
                _isLoading.value = true
                val allLocations = mutableListOf<Location>()
                var currentPage = 1

                while (true) {
                    val response = api.fetchAllLocation(page = currentPage)
                    allLocations.addAll(response.results)
                    if (response.info.next == null) break
                    currentPage++
                }

                _locations.value = allLocations
            } catch (e: Exception) {
                e.printStackTrace()
            } finally {
                _isLoading.value = false
            }
        }
    }
}