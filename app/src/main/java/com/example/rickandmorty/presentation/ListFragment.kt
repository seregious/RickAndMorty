package com.example.rickandmorty.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import com.example.rickandmorty.R
import com.example.rickandmorty.data.NetworkManager
import com.example.rickandmorty.databinding.FragmentListBinding
import com.example.rickandmorty.presentation.adapters.CharactersAdapter
import com.example.rickandmorty.presentation.adapters.EpisodesAdapter
import com.example.rickandmorty.presentation.adapters.LocationsAdapter
import kotlinx.coroutines.launch


class ListFragment : Fragment() {

    private lateinit var binding: FragmentListBinding
    private lateinit var charactersAdapter: CharactersAdapter
    private lateinit var locationsAdapter: LocationsAdapter
    private lateinit var episodesAdapter: EpisodesAdapter
    private val viewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentListBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setupAdapter()

        binding.backButton.setOnClickListener {
            setupMenuFragment()
        }
    }

    private fun setupAdapter() {
        when(viewModel.screen.value) {
            1 -> {
                setupCharactersAdapter()
            }
            2 -> {
                setupLocationsAdapter()
            }
            else -> {
                setupEpisodesAdapter()
            }
        }
    }

    private fun setupCharactersAdapter() {
        charactersAdapter = CharactersAdapter()
        binding.rcFragment.adapter = charactersAdapter
        lifecycleScope.launch{
            charactersAdapter.characterList = NetworkManager.getCharacters.getCharacters().results
        }
    }

    private fun setupLocationsAdapter() {
        locationsAdapter = LocationsAdapter()
        binding.rcFragment.adapter = locationsAdapter
        lifecycleScope.launch{
            locationsAdapter.locationList = NetworkManager.getLocations.getLocations().results
        }
    }

    private fun setupEpisodesAdapter() {
        episodesAdapter = EpisodesAdapter()
        binding.rcFragment.adapter = episodesAdapter
        lifecycleScope.launch{
            episodesAdapter.episodesList = NetworkManager.getEpisodes.getEpisodes().results
        }
    }

    private fun setupMenuFragment() {
        parentFragmentManager.beginTransaction().replace(R.id.mainFrame, MenuFragment()).commit()

    }

    companion object {
        @JvmStatic
        fun newInstance() = ListFragment()
    }
}