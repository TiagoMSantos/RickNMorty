package com.tiagomdosantos.rickyandmorty.data

import com.tiagomdosantos.rickyandmorty.data.entities.CharacterDto
import com.tiagomdosantos.rickyandmorty.data.entities.CharacterResponseDto
import com.tiagomdosantos.rickyandmorty.data.entities.EpisodeDto
import com.tiagomdosantos.rickyandmorty.data.entities.EpisodeResponseDto
import com.tiagomdosantos.rickyandmorty.data.entities.LocationDto
import com.tiagomdosantos.rickyandmorty.data.entities.LocationResponseDto
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @GET("character")
    suspend fun getCharacters(
        @Query("page") page: Int,
        @Query("name") name: String? = null,
        @Query("status") status: String? = null,
        @Query("species") species: String? = null,
        @Query("type") type: String? = null,
        @Query("gender") gender: String? = null
    ): CharacterResponseDto

    @GET("character/{id}")
    suspend fun getCharacterDetails(
        @Path("id") characterId: Int
    ): CharacterDto

    @GET("episode")
    suspend fun getEpisodes(
        @Query("page") page: Int
    ): EpisodeResponseDto

    @GET("episode/{id}")
    suspend fun getEpisodeDetails(
        @Path("id") episodeId: Int
    ): EpisodeDto

    @GET("location")
    suspend fun getLocations(
        @Query("page") page: Int,
        @Query("name") name: String? = null,
        @Query("type") type: String? = null,
        @Query("dimension") dimension: String? = null
    ): LocationResponseDto

    @GET("location/{id}")
    suspend fun getLocationDetails(
        @Path("id") locationId: Int
    ): LocationDto
}