package com.example.rickandmorty.ui.viewModule

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rickandmorty.data.api.RickAndMortyApi
import com.example.rickandmorty.data.model.Character
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class CharacterViewModule(private val api: RickAndMortyApi) : ViewModel() {

    private val _character = MutableStateFlow<List<Character>>(emptyList())
    val characters: StateFlow<List<Character>> = _character

    private val _isLoading = MutableStateFlow(true)
    val isLoading: StateFlow<Boolean> = _isLoading

    init {
        fetchAllCharacters()
    }

    private fun fetchAllCharacters() {
        viewModelScope.launch {
            try {
                _isLoading.value = true
                val allCharacters = mutableListOf<Character>()
                var currentPage = 1

                while (true) {
                    val response = api.fetchAllCharacter(page = currentPage)
                    allCharacters.addAll(response.results)
                    if (response.info.next == null) break
                    currentPage++
                }

                _character.value = allCharacters
            } catch (e: Exception) {
                e.printStackTrace()
            } finally {
                _isLoading.value = false
            }
        }
    }
}

