package com.tiagomdosantos.rickyandmorty.ui.episodes

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.tiagomdosantos.rickyandmorty.data.entities.EpisodeDto
import com.tiagomdosantos.rickyandmorty.domain.repositories.episodes.EpisodesPagingSource
import com.tiagomdosantos.rickyandmorty.domain.repositories.episodes.EpisodesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class EpisodesListViewModel @Inject constructor(
    private val repository: EpisodesRepository
) : ViewModel() {

    val listState: Flow<PagingData<EpisodeDto>> = Pager(
        config = PagingConfig(
            pageSize = 20,
            enablePlaceholders = false
        ),
        pagingSourceFactory = {
            EpisodesPagingSource(repository)
        }
    ).flow
        .cachedIn(viewModelScope)

}