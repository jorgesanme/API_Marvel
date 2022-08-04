package com.jorgeSM.apimarvel.presentation.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.jorgeSM.apimarvel.R
import com.jorgeSM.apimarvel.databinding.ItemCharacterBinding
import com.jorgeSM.apimarvel.presentation.modelVO.CharacterVO

class CharacterAdapter(
    private var characterList: List<CharacterVO>
) : RecyclerView.Adapter<CharacterAdapter.ViewHolder>() {

    private lateinit var mContext: Context


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        mContext = parent.context
        val view = LayoutInflater.from(mContext).inflate(R.layout.item_character, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
        holder.bind(characterList[position])


    override fun getItemCount(): Int = characterList.size


    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val binding = ItemCharacterBinding.bind(view)
        fun bind(character: CharacterVO) {
            binding.tvName.text = character.name
            Glide.with(binding.root)
                .load(character.image)
                .circleCrop()
                .into(binding.imageView)

        }

    }
}