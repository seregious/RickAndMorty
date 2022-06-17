package com.example.rickandmorty.presentation

import android.widget.Toast
import androidx.lifecycle.*
import com.example.rickandmorty.data.Constants
import com.example.rickandmorty.data.NetworkManager
import com.example.rickandmorty.domain.*
import kotlinx.coroutines.launch
import java.lang.Exception

class MainViewModel: ViewModel() {

    val screen: MutableLiveData<Int> by lazy {
        MutableLiveData<Int>()
    }

    val networkStatus: MutableLiveData<Boolean> by lazy {
        MutableLiveData<Boolean>()
    }

    var characterList = MutableLiveData<List<Character>>()
    var locationList = MutableLiveData<List<Location>>()
    val episodeList = MutableLiveData<List<Episode>>()

    fun getCharactersList() {
        var list: List<Character>
        viewModelScope.launch {
            try {
                list = NetworkManager.getCharacters.getCharacters().results
                characterList.postValue(list)
                networkStatus.value = Constants.NETWORK_OK
            } catch(e: Exception) {
                networkStatus.value = Constants.NETWORK_NOT_OK
            }
        }
    }

    fun getEpisodeList() {
        var list: List<Episode>
        viewModelScope.launch {
            try {
                list = NetworkManager.getEpisodes.getEpisodes().results
                episodeList.postValue(list)
                networkStatus.value = Constants.NETWORK_OK
            } catch(e: Exception) {
                networkStatus.value = Constants.NETWORK_NOT_OK
            }
        }
    }

    fun getLocationList()  {
        var list: List<Location>
        viewModelScope.launch {
            try {
                list = NetworkManager.getLocations.getLocations().results
                locationList.postValue(list)
                networkStatus.value = Constants.NETWORK_OK
            } catch(e: Exception) {
                networkStatus.value = Constants.NETWORK_NOT_OK
            }
        }
    }
}