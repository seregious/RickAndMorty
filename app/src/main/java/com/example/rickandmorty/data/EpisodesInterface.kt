package com.example.rickandmorty.data

import com.example.rickandmorty.domain.Episodes
import retrofit2.http.GET

interface EpisodesInterface {
    @GET("episode")
    suspend fun getEpisodes(): Episodes
}