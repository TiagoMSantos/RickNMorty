package com.tiagomdosantos.rickyandmorty.data.entities

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

data class CharacterResponseDto(
    val info: PageInfoDto,
    val results: List<CharacterDto>
)

data class PageInfoDto(
    val count: Int,
    val pages: Int,
    val next: String?,
    val prev: String?
)

@Parcelize
data class CharacterDto(
    val id: Int,
    val name: String,
    val status: Status,
    val species: String,
    val type: String,
    val gender: Gender,
    val origin: LocationInfoDto,
    val location: LocationInfoDto,
    val image: String,
    val episode: List<String>,
    val url: String,
    val created: String
): Parcelable

enum class Status {
    Alive,
    Dead,
    unknown
}

enum class Gender {
    Female,
    Male,
    Genderless,
    unknown
}

@Parcelize
data class LocationInfoDto(
    val name: String,
    val url: String
): Parcelable

data class EpisodeResponseDto(
    val info: PageInfoDto,
    val results: List<EpisodeDto>
)

data class EpisodeDto(
    val id: Int,
    val name: String,
    val air_date: String,
    val episode: String,
    val characters: List<String>,
    val url: String,
    val created: String
)

data class LocationResponseDto(
    val info: PageInfoDto,
    val results: List<LocationDto>
)

data class LocationDto(
    val id: Int,
    val name: String,
    val type: String,
    val dimension: String,
    val residents: List<String>,
    val url: String,
    val created: String
)