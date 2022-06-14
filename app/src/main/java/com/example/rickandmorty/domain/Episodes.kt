package com.example.rickandmorty.domain

data class Episodes(
    val results: List<Episode>
)

data class Episode (
    override val name: String,
    val air_date: String,
    val episode: String
        ): Item(name)
