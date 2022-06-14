package com.example.rickandmorty.presentation.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.rickandmorty.R
import com.example.rickandmorty.databinding.LocationCardBinding
import com.example.rickandmorty.domain.Location

class LocationsAdapter: RecyclerView.Adapter<LocationsAdapter.LocationHolder>() {

    var locationList: List<Location> = listOf()
    set(value) {
        field = value
        notifyDataSetChanged()
    }

    class LocationHolder(view: View): RecyclerView.ViewHolder(view) {
        private var binding = LocationCardBinding.bind(view)

        fun bind(location: Location) = with(binding){
            locationNameText.text = location.name
            locationTypeText.text = location.type
            locationDimensionText.text = location.dimension
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LocationHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.location_card, parent, false)
        return LocationHolder(view)
    }

    override fun onBindViewHolder(holder: LocationHolder, position: Int) {
        holder.bind(locationList[position])
    }

    override fun getItemCount(): Int {
        return locationList.size
    }
}