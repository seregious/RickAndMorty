package com.example.rickandmorty

import com.example.rickandmorty.models.Characters
import com.example.rickandmorty.models.Episodes
import com.example.rickandmorty.models.Locations
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

object NetworkManager {

    interface CharactersApi {
        @GET("character")
        suspend fun getCountryByName(@Path("name") country: String): Characters
    }

    interface EpisodesApi {
        @GET("character")
        suspend fun getCountryByName(@Path("name") country: String): Episodes
    }

    interface LocationsApi {
        @GET("character")
        suspend fun getCountryByName(@Path("name") country: String): Locations
    }

    private var retrofit = Retrofit.Builder()
        .baseUrl("https://rickandmortyapi.com/api")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    var getCharacters = retrofit.create(CharactersApi::class.java)
    var getEpisodes = retrofit.create(CharactersApi::class.java)
    var getLocations = retrofit.create(CharactersApi::class.java)
}