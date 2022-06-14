package com.example.rickandmorty.presentation.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.rickandmorty.R
import com.example.rickandmorty.databinding.EpisodeCardBinding
import com.example.rickandmorty.domain.Episode

class EpisodesAdapter: RecyclerView.Adapter<EpisodesAdapter.EpisodeHolder>() {

        var episodesList: List<Episode> = listOf()
            set(value) {
                field = value
                notifyDataSetChanged()
            }

        class EpisodeHolder(view: View): RecyclerView.ViewHolder(view) {
            private var binding = EpisodeCardBinding.bind(view)

            fun bind(episode: Episode) = with(binding){
                episodeNameText.text = episode.name
                episodeAirDateText.text = episode.air_date
                episodeSeasonText.text = episode.episode.subSequence(1,3)
                episodeNumberText.text = episode.episode.subSequence(4,6)
            }
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EpisodeHolder {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.episode_card, parent, false)
            return EpisodeHolder(view)
        }

        override fun onBindViewHolder(holder: EpisodeHolder, position: Int) {
            holder.bind(episodesList[position])
        }

        override fun getItemCount(): Int {
            return episodesList.size
        }
    }