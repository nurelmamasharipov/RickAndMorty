package com.example.rickandmorty.data.model

import com.google.gson.annotations.SerializedName

data class CharactersResponse(
    @SerializedName("results") val results: List<Character>,
    @SerializedName("info") val info: Info
)

data class Character(
    val id: Int,
    val name: String,
    val status: String,
    val species: String,
    val type: String,
    val gender: String,
    val origin: Location,
    val location: Location,
    val image: String,
    val episode: List<String>,
)
