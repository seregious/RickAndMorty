package com.example.rickandmorty.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.rickandmorty.R
import com.example.rickandmorty.databinding.FragmentMenuBinding


class MenuFragment : Fragment() {
    lateinit var binding: FragmentMenuBinding
    private val viewModel: MainViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMenuBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        charactersButton()
        locationsButton()
        episodesButton()
    }

    private fun charactersButton() {
        binding.charactersButton.setOnClickListener {
            viewModel.screen.value = 1
            setupFragment()
        }
    }

    private fun locationsButton() {
        binding.locationsButton.setOnClickListener {
            viewModel.screen.value = 2
            setupFragment()
        }
    }

    private fun episodesButton() {
        binding.episodesButton.setOnClickListener {
            viewModel.screen.value = 3
            setupFragment()
        }
    }

    private fun setupFragment() {
        parentFragmentManager.beginTransaction().replace(R.id.mainFrame, ListFragment()).commit()
    }



    companion object {
        @JvmStatic
        fun newInstance() = MenuFragment()
    }
}