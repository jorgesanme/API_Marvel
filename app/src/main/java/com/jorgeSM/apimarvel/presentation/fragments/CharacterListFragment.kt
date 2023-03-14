package com.jorgeSM.apimarvel.presentation.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.jorgeSM.apimarvel.R
import com.jorgeSM.apimarvel.databinding.FragmentCharacterListBinding
import com.jorgeSM.apimarvel.presentation.activity.MainActivity
import com.jorgeSM.apimarvel.presentation.adapter.CharacterAdapter
import com.jorgeSM.apimarvel.presentation.modelVO.ResultVO
import com.jorgeSM.apimarvel.utils.Utils
import com.jorgeSM.apimarvel.presentation.viewmodel.CharacterListViewModel
import kotlinx.coroutines.launch

class CharacterListFragment : Fragment() {

    private lateinit var mBinding: FragmentCharacterListBinding
    private lateinit var mAdapter: CharacterAdapter
    private lateinit var linearLayoutManager: LinearLayoutManager
    private val mViewModel: CharacterListViewModel by viewModels()
    private lateinit var mContext: Context


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = FragmentCharacterListBinding.inflate(inflater, container, false).also {
        mBinding = it

    }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupToolbar()
        showProgressbar()
        initList()
        setupObserver()
    }

    private fun setupToolbar() {
        (activity as MainActivity).let { activity ->
            activity.supportActionBar?.setDisplayHomeAsUpEnabled(true)
            activity.supportActionBar?.title = getString(R.string.fragment_title_list)
        }
    }

    private fun showProgressbar() {
        mBinding.progressBar.progress
    }


    private fun initList() {
        mContext = mBinding.root.context
        mViewModel.getCharacterList(Utils.createEndPointHash())
    }


    private fun setupObserver() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED){
                mViewModel.state.collect{
                    it.characters?.let { list ->
                        setupRecycleView(list)
                    }
                    mBinding.progressBar.visibility = if(it.loading) View.VISIBLE else View.GONE
                }
            }
        }
    }

    private fun setupRecycleView(list: List<ResultVO>) {
        mAdapter = CharacterAdapter(
            list,
            onClick = { onCardClicked(it) })

        linearLayoutManager = LinearLayoutManager(mContext)
        mBinding.rvCharacters.apply {
            setHasFixedSize(true)
            layoutManager = linearLayoutManager
            adapter = mAdapter
        }
    }

    private fun onCardClicked(character: ResultVO) {
        val bundle = bundleOf().apply {
            putString(CHARACTER_ID, character.id.toString())
            putString(CHARACTER_NAME, character.name)
        }
        findNavController().navigate(R.id.characterDetailFragment, bundle)
        mViewModel.onNavigationDone()

    }
}


