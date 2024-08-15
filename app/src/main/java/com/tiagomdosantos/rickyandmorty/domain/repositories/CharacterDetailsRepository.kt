package com.tiagomdosantos.rickyandmorty.domain.repositories

import com.tiagomdosantos.rickyandmorty.domain.models.CharacterDetails

interface CharacterDetailsRepository {
    suspend fun getCharacterDetails(id: Int): Result<CharacterDetails>
}