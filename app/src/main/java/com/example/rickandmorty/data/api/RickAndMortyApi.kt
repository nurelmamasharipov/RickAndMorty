package com.example.rickandmorty.data.api

import com.example.rickandmorty.data.model.Character
import com.example.rickandmorty.data.model.CharactersResponse
import com.example.rickandmorty.data.model.EpisodeResponse
import com.example.rickandmorty.data.model.LocationsResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RickAndMortyApi {

    @GET("character")
    suspend fun fetchAllCharacter(
        @Query("page") page: Int = 1
    ) : CharactersResponse

    @GET("character/{id}")
    suspend fun getCharacterById(
        @Path("id") id: Int): Character

    @GET("location")
    suspend fun fetchAllLocation(
        @Query("page") page:Int = 1
    ) : LocationsResponse

    @GET("episode")
    suspend fun fetchAllEpisode(
        @Query("page") page:Int = 1
    ) : EpisodeResponse

}