package com.tiagomdosantos.rickyandmorty.domain.repositories

import androidx.paging.PagingData
import com.tiagomdosantos.rickyandmorty.domain.models.Episode
import kotlinx.coroutines.flow.Flow

interface EpisodesRepository {
    suspend fun getAllEpisodes(): Flow<PagingData<Episode>>
}

interface SingleEpisodeRepository {
    suspend fun getEpisode(episodeId: String): Result<List<Episode>>
}