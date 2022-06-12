package com.example.rickandmorty.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import com.example.rickandmorty.NetworkManager
import com.example.rickandmorty.databinding.ActivityMainBinding
import kotlinx.coroutines.launch

class MainMenuActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        lifecycleScope.launch {
            NetworkManager.getCharacters
            NetworkManager.getLocations
            NetworkManager.getEpisodes
        }
    }
}