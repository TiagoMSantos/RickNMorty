package com.tiagomdosantos.rickyandmorty.domain.repositories.episodes

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.tiagomdosantos.rickyandmorty.data.entities.EpisodeDto

class EpisodesPagingSource(
    private val repository: EpisodesRepository,
) : PagingSource<Int, EpisodeDto>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, EpisodeDto> {
        return try {
            val page = params.key ?: 1
            val response = repository.getAllEpisodes(page)

            LoadResult.Page(
                data = response.results,
                prevKey = if (page == 1) null else page - 1,
                nextKey = if (response.info.next == null) null else page + 1
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, EpisodeDto>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }
}