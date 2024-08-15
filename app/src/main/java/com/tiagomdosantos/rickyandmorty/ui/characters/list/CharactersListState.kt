package com.tiagomdosantos.rickyandmorty.ui.characters.list

import androidx.paging.PagingData
import com.tiagomdosantos.rickyandmorty.domain.models.Character
import kotlinx.coroutines.flow.Flow

data class CharactersListState(
    var isLoading: Boolean = false,
    val dataList: Flow<PagingData<Character>>? = null,
    val errorMessage: String = ""
)