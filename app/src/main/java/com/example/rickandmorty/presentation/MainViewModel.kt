package com.example.rickandmorty.presentation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rickandmorty.data.NetworkManager
import com.example.rickandmorty.domain.Character
import com.example.rickandmorty.domain.Episode
import com.example.rickandmorty.domain.Location
import com.example.rickandmorty.domain.Origin
import kotlinx.coroutines.launch

class MainViewModel(): ViewModel() {

    val screen: MutableLiveData<Int> by lazy {
        MutableLiveData<Int>()
    }


    var charactersList = {
        var list: List<Character> = arrayListOf()
        viewModelScope.launch {
            list =  NetworkManager.getCharacters.getCharacters().results
        }
        list
    }

    var episodesList = {
        var list: List<Episode> = arrayListOf()
        viewModelScope.launch {
            list =  NetworkManager.getEpisodes.getEpisodes().results
        }
        list
    }

    var locationsList =  {
        var list: List<Location> = arrayListOf()
        viewModelScope.launch {
            list =  NetworkManager.getLocations.getLocations().results
        }
        list
    }

}