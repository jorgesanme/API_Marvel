package com.jorgeSM.apimarvel.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.jorgeSM.apimarvel.databinding.FragmentCharacterDetailBinding
import com.jorgeSM.apimarvel.presentation.activity.MainActivity
import com.jorgeSM.apimarvel.presentation.modelVO.ResultVO
import com.jorgeSM.apimarvel.presentation.viewmodel.DetailsViewModel
import com.jorgeSM.apimarvel.utils.Utils
import jp.wasabeef.glide.transformations.RoundedCornersTransformation
import kotlinx.coroutines.launch

const val CHARACTER_ID = "id"
const val CHARACTER_NAME = "name"

class CharacterDetailFragment : Fragment() {
    private lateinit var mBinding: FragmentCharacterDetailBinding
    private val mViewModel: DetailsViewModel by viewModels()
    private var characterId: String? = null
    private var name: String? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = FragmentCharacterDetailBinding.inflate(inflater, container, false)
        .also { mBinding = it }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getParams()
        setupToolbar()
        getCharacterDetails()
        setupObserver()
    }

    private fun setupObserver() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                mViewModel.character.collect {
                    it.character?.let { resultVO ->
                        setupView(resultVO)
                    }
                    mBinding.progressBar.visibility = if (it.loading) View.VISIBLE else View.GONE
                }
            }
        }
    }

    private fun getCharacterDetails() {
        characterId?.let { characterId ->
            mViewModel.getCharacterById(characterId, Utils.createEndPointHash())
        }
    }

    private fun setupToolbar() {
        (activity as? MainActivity).let { activity ->
            activity?.supportActionBar?.setDisplayHomeAsUpEnabled(true)
            activity?.supportActionBar?.title = name
        }
    }

    private fun getParams() {
        characterId = arguments?.getString(CHARACTER_ID)
        name = arguments?.getString(CHARACTER_NAME)
    }

    private fun setupView(character: ResultVO) {
        setupToolbar()
        with(mBinding) {
            tvDescription.text = character.description
            tvComic.text = character.comics?.available.toString()
            tvEvents.text = character.events?.available.toString()
            tvSeries.text = character.series?.available.toString()
            tvStories.text = character.stories?.available.toString()
            Glide.with(root)
                .load(character.image)
                .transform(RoundedCornersTransformation(16, 0))
                .into(image)


        }
    }

    @Deprecated("Deprecated in Java")
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                findNavController().navigateUp()
                true
            }
            else -> return true
        }
    }

}