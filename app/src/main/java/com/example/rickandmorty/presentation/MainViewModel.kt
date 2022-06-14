package com.example.rickandmorty.presentation

import androidx.lifecycle.*
import com.example.rickandmorty.data.NetworkManager
import com.example.rickandmorty.domain.*
import kotlinx.coroutines.launch

class MainViewModel: ViewModel() {

    val screen: MutableLiveData<Int> by lazy {
        MutableLiveData<Int>()
    }

    var characterList = MutableLiveData<List<Character>>()
    var locationList = MutableLiveData<List<Location>>()
    val episodeList = MutableLiveData<List<Episode>>()

    fun getCharactersList() {
        var list: List<Character>
        viewModelScope.launch {
            list =  NetworkManager.getCharacters.getCharacters().results
                characterList.postValue(list)
            }
    }

    fun getEpisodeList() {
        var list: List<Episode>
        viewModelScope.launch {
            list =  NetworkManager.getEpisodes.getEpisodes().results
            episodeList.postValue(list)
        }
    }

    fun getLocationList()  {
        var list: List<Location>
        viewModelScope.launch {
            list =  NetworkManager.getLocations.getLocations().results
            locationList.postValue(list)
        }
    }
}