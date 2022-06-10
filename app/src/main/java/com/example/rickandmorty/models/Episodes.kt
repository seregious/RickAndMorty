package com.example.rickandmorty.models

data class Episodes(
    val results: List<Episode>
)

data class Episode (
    val name: String,
    val air_date: String,
    val episode: String
        )
