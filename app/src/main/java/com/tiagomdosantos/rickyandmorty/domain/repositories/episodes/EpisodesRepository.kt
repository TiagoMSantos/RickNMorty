package com.tiagomdosantos.rickyandmorty.domain.repositories.episodes

import com.tiagomdosantos.rickyandmorty.data.ApiService
import com.tiagomdosantos.rickyandmorty.data.entities.EpisodeDto
import com.tiagomdosantos.rickyandmorty.data.entities.EpisodeResponseDto
import javax.inject.Inject

class EpisodesRepository @Inject constructor(
    private val apiService: ApiService
) {
    suspend fun getAllEpisodes(page: Int): EpisodeResponseDto {
        return apiService.getEpisodes(page = page)
    }

    suspend fun getEpisode(episodeId: Int): EpisodeDto {
        return apiService.getEpisodeDetails(episodeId = episodeId)
    }
}