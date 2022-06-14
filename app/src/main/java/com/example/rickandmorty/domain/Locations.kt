package com.example.rickandmorty.domain

data class Locations(
    val results: List<Location>
)

data class Location(
    override val name: String,
    val type: String,
    val dimension: String
): Item(name)
