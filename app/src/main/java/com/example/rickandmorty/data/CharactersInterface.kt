package com.example.rickandmorty.data

import com.example.rickandmorty.domain.Characters
import retrofit2.http.GET

interface CharactersInterface {
    @GET("character")
    suspend fun getCharacters(): Characters
}