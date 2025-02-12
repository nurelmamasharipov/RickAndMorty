package com.example.rickandmorty.ui.viewModule

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rickandmorty.data.api.RickAndMortyApi
import com.example.rickandmorty.data.model.Character
import com.example.rickandmorty.data.model.Episode
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class EpisodeViewModule(private val api:RickAndMortyApi) : ViewModel() {

    private val _episode = MutableStateFlow<List<Episode>>(emptyList())
    val episodes: StateFlow<List<Episode>> = _episode

    private val _isLoading = MutableStateFlow(true)
    val isLoading: StateFlow<Boolean> = _isLoading

    init {
        fetchAllEpisodes()
    }

    private fun fetchAllEpisodes() {
        viewModelScope.launch {
            try {
                _isLoading.value = true
                val allEpisodes = mutableListOf<Episode>()
                var currentPage = 1

                while (true) {
                    val response = api.fetchAllEpisode(page = currentPage)
                    allEpisodes.addAll(response.results)
                    if (response.info.next == null) break
                    currentPage++
                }

                _episode.value = allEpisodes
            } catch (e: Exception) {
                e.printStackTrace()
            } finally {
                _isLoading.value = false
            }
        }
    }
}