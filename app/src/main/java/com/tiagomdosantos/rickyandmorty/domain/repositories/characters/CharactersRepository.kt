package com.tiagomdosantos.rickyandmorty.domain.repositories.characters

import com.tiagomdosantos.rickyandmorty.data.ApiService
import com.tiagomdosantos.rickyandmorty.data.entities.CharacterDto
import com.tiagomdosantos.rickyandmorty.data.entities.CharacterResponseDto
import javax.inject.Inject

class CharactersRepository @Inject constructor(
    private val apiService: ApiService
) {
    // Fetch characters from the API with optional filtering
    suspend fun getCharacters(
        page: Int,
        name: String? = null,
        status: String? = null,
        species: String? = null,
        type: String? = null,
        gender: String? = null
    ): CharacterResponseDto {
        return apiService.getCharacters(page, name, status, species, type, gender)
    }

    // Fetch character details by ID
    suspend fun getCharacterDetails(characterId: Int): CharacterDto {
        return apiService.getCharacterDetails(characterId)
    }
}