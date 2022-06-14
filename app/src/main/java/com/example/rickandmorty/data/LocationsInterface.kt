package com.example.rickandmorty.data

import com.example.rickandmorty.domain.Locations
import retrofit2.http.GET

interface LocationsInterface {
    @GET("location")
    suspend fun getLocations(): Locations
}