package com.example.rickandmorty.data.model

import com.google.gson.annotations.SerializedName

data class LocationsResponse(
    @SerializedName("results") val results: List<Location>,
    @SerializedName("info") val info: Info
)

data class Location(
    val id: Int,
    val name: String,
    val type: String,
    val dimension: String,
    val residents: List<String>,
    val url: String,
    val created: String
)
