package com.example.rickandmorty.data.model

import com.google.gson.annotations.SerializedName

data class EpisodeResponse(
    @SerializedName("results") val results: List<Episode>,
    @SerializedName("info") val info: Info
)


data class Episode(
    val id: Int,
    val name: String,
    val air_date: String,
    val episode: String,
    val characters: List<String>,
    val url: String,
    val created: String
)
