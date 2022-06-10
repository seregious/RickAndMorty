package com.example.rickandmorty.models

data class Locations(
    val results: List<Location>
)

data class Location(
    val name: String,
    val type: String,
    val dimension: String
)
