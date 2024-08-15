package com.tiagomdosantos.rickyandmorty.ui.character

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.tiagomdosantos.rickyandmorty.data.entities.CharacterDto
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import com.tiagomdosantos.rickyandmorty.domain.repositories.CharactersRepository
import kotlinx.coroutines.flow.Flow

@HiltViewModel
class CharactersListViewModel @Inject constructor(
    private val repository: CharactersRepository
) : ViewModel() {

    val charactersListState: Flow<PagingData<CharacterDto>> = Pager(
        config = PagingConfig(
            pageSize = 20,
            enablePlaceholders = false
        ),
        pagingSourceFactory = {
            CharactersPagingSource(repository)
        }
    ).flow
        .cachedIn(viewModelScope)
}