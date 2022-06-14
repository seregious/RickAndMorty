package com.example.rickandmorty.presentation

import android.app.Application
import androidx.lifecycle.*
import com.example.rickandmorty.data.NetworkManager
import com.example.rickandmorty.domain.*
import kotlinx.coroutines.launch

class MainViewModel(): ViewModel() {

    val screen: MutableLiveData<Int> by lazy {
        MutableLiveData<Int>()
    }

    var characterList = MutableLiveData<List<Character>>()
    var locationList = MutableLiveData<List<Location>>()
    val episodeList = MutableLiveData<List<Episode>>()

    private val search = MutableLiveData<String>()


    fun getCharactersList() {
        var list: List<Character> = arrayListOf()
        viewModelScope.launch {
            list =  NetworkManager.getCharacters.getCharacters().results
                characterList.postValue(list)
            }
    }

    fun getEpisodeList() {
        var list: List<Episode> = arrayListOf()
        viewModelScope.launch {
            list =  NetworkManager.getEpisodes.getEpisodes().results
            episodeList.postValue(list)
        }
    }

    fun getLocationList()  {
        var list: List<Location> = arrayListOf()
        viewModelScope.launch {
            list =  NetworkManager.getLocations.getLocations().results
            locationList.postValue(list)
        }
    }
}