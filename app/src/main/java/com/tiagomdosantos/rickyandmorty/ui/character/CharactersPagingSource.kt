package com.tiagomdosantos.rickyandmorty.ui.character

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.tiagomdosantos.rickyandmorty.data.entities.CharacterDto
import com.tiagomdosantos.rickyandmorty.domain.repositories.CharactersRepository

class CharactersPagingSource(
    private val repository: CharactersRepository,
    private val name: String? = null,
    private val status: String? = null,
    private val species: String? = null,
    private val type: String? = null,
    private val gender: String? = null
) : PagingSource<Int, CharacterDto>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, CharacterDto> {
        return try {
            val page = params.key ?: 1
            val response = repository.getCharacters(page, name, status, species, type, gender)

            LoadResult.Page(
                data = response.results,
                prevKey = if (page == 1) null else page - 1,
                nextKey = if (response.info.next == null) null else page + 1
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, CharacterDto>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }
}