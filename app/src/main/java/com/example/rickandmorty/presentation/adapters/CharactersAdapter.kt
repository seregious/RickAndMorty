package com.example.rickandmorty.presentation.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.rickandmorty.R
import com.example.rickandmorty.databinding.CharacterCardBinding
import com.example.rickandmorty.domain.Character
import com.squareup.picasso.Picasso

class CharactersAdapter: RecyclerView.Adapter<CharactersAdapter.CharacterHolder>() {

    var characterList: List<Character> = listOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    class CharacterHolder(view: View): RecyclerView.ViewHolder(view) {
        private var binding = CharacterCardBinding.bind(view)

        fun bind(character: Character) = with(binding){
            characterNameText.text = character.name
            charGenderText.text = character.gender
            charSpeciesText.text = character.species
            charLocationText.text = character.location.name
            Picasso.get().load(character.image).into(imageView)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.character_card, parent, false)
        return CharacterHolder(view)
    }

    override fun onBindViewHolder(holder: CharacterHolder, position: Int) {
        holder.bind(characterList[position])
    }

    override fun getItemCount(): Int {
        return characterList.size
    }
}