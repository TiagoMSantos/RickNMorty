package com.tiagomdosantos.rickyandmorty.domain.models

data class Character(
    val id: Int,
    val name: String,
    val imageUrl: String,
    val gender: String,
    val status: String,
    val species:String,
    val origin:String,
)