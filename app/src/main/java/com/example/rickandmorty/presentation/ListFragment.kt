package com.example.rickandmorty.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.activityViewModels
import com.example.rickandmorty.R
import com.example.rickandmorty.data.Constants
import com.example.rickandmorty.databinding.FragmentListBinding
import com.example.rickandmorty.presentation.adapters.CharactersAdapter
import com.example.rickandmorty.presentation.adapters.EpisodesAdapter
import com.example.rickandmorty.presentation.adapters.LocationsAdapter


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
        setupSearchButton()
        binding.backButton.setOnClickListener {
            backToMenuFragment()
            (activity as AppCompatActivity).supportActionBar?.title = Constants.MAIN_TITLE
        }
    }

    private fun setupAdapter() {
        when(viewModel.screen.value) {
            1 -> {
                setupCharactersAdapter()
                (activity as AppCompatActivity).supportActionBar?.title = Constants.CHAR_TITLE
            }
            2 -> {
                setupLocationsAdapter()
                (activity as AppCompatActivity).supportActionBar?.title = Constants.LOC_TITLE
            }
            else -> {
                setupEpisodesAdapter()
                (activity as AppCompatActivity).supportActionBar?.title = Constants.EPI_TITLE
            }
        }
    }

    private fun setupCharactersAdapter() {
        viewModel.getCharactersList()
        charactersAdapter = CharactersAdapter()
        binding.rcFragment.adapter = charactersAdapter
            viewModel.characterList.observe(viewLifecycleOwner) {
                charactersAdapter.characterList = it
            }

    }

    private fun setupLocationsAdapter() {
        viewModel.getLocationList()
        locationsAdapter = LocationsAdapter()
        binding.rcFragment.adapter = locationsAdapter
        viewModel.locationList.observe(viewLifecycleOwner) {
            locationsAdapter.locationList = it
        }
    }

    private fun setupEpisodesAdapter() {
        viewModel.getEpisodeList()
        episodesAdapter = EpisodesAdapter()
        binding.rcFragment.adapter = episodesAdapter
        viewModel.episodeList.observe(viewLifecycleOwner) {
            episodesAdapter.episodesList = it
        }
    }

    private fun backToMenuFragment() {
        parentFragmentManager.beginTransaction().replace(R.id.mainFrame, MenuFragment()).commit()
    }

    private fun setupSearchButton() = with(binding) {
        searchButton.setOnClickListener {
            val text = searchText.text.toString()
            val itemSearch =
                viewModel.characterList.value?.filter { it.name.uppercase().contains(text.uppercase()) }
            charactersAdapter.characterList = itemSearch ?: emptyList()
        }
    }
}