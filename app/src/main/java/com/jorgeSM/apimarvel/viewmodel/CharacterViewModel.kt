package com.jorgeSM.apimarvel.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jorgeSM.apimarvel.data.MarvelRepositoryImp
import com.jorgeSM.apimarvel.data.remote.models.ListOfCharacterRequest
import com.jorgeSM.apimarvel.presentation.mapper.transformToVO
import com.jorgeSM.apimarvel.presentation.modelVO.ResultVO
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class CharacterViewModel(
    private val marvelRepositoryImp: MarvelRepositoryImp = MarvelRepositoryImp()
) : ViewModel() {

    private val _characterList = MutableLiveData<List<ResultVO>>()
    val characterList: LiveData<List<ResultVO>> get() = _characterList

    private var requestJob: Job? = null

    fun getCharacterList(hash: String) {
        requestJob?.cancel()
        val list1 = mutableListOf<ResultVO>()
        requestJob = viewModelScope.launch(Dispatchers.IO) {
            val characterList = marvelRepositoryImp.getCharacterList(ListOfCharacterRequest(hash))
            withContext(Dispatchers.Main) {
                characterList.map {
                    it?.data?.results?.map { result ->
                        list1.add(result.transformToVO())
                    }
                }
                _characterList.postValue(list1)
            }
        }
    }
}