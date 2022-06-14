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
import com.example.rickandmorty.domain.Character
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
            backToMenuFragment()
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

    companion object {
        @JvmStatic
        fun newInstance() = ListFragment()
    }
}