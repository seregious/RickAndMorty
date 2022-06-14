package com.example.rickandmorty.data


import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object NetworkManager {

    private var retrofit = Retrofit.Builder()
        .baseUrl("https://rickandmortyapi.com/api/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    var getCharacters: CharactersInterface = retrofit.create(CharactersInterface::class.java)
    var getEpisodes: EpisodesInterface = retrofit.create(EpisodesInterface::class.java)
    var getLocations: LocationsInterface = retrofit.create(LocationsInterface::class.java)
}