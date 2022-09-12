package com.jorgeSM.apimarvel.presentation.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.jorgeSM.apimarvel.R
import com.jorgeSM.apimarvel.databinding.ItemCharacterBinding
import com.jorgeSM.apimarvel.presentation.modelVO.ResultVO
import jp.wasabeef.glide.transformations.RoundedCornersTransformation

class CharacterAdapter(
    private var characterList: List<ResultVO>,
    private val onClick: (ResultVO) -> Unit
) : RecyclerView.Adapter<CharacterAdapter.ViewHolder>() {

    private lateinit var mContext: Context


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        mContext = parent.context
        val view = LayoutInflater.from(mContext).inflate(R.layout.item_character, parent, false)
        return ViewHolder(view, onClick)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
        holder.bind(characterList[position])

    override fun getItemCount(): Int = characterList.size


    inner class ViewHolder(
        view: View,
        private val onClick: (ResultVO) -> Unit
    ) : RecyclerView.ViewHolder(view) {
        private val binding = ItemCharacterBinding.bind(view)

        fun bind(character: ResultVO) {
            with(binding) {
                tvName.text = character.name
                tvId.text = character.id.toString()
                tvDescription.text = character.description

                // FIXME: Dar formato a la fecha
                character.modified?.let {tvModified.text = root.context.getString(R.string.modified) + ": $it"}

                cvCharacter.setOnClickListener { onClick(character) }
                Glide.with(root)
                    .load(character.image)
                    .centerCrop()
                    .transform(RoundedCornersTransformation(16, 0))
                    .into(imageView)
            }
        }

    }
}