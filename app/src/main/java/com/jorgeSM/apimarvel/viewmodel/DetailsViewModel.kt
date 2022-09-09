package com.jorgeSM.apimarvel.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jorgeSM.apimarvel.data.remote.models.CharacterItemByIdRequest
import com.jorgeSM.apimarvel.domain.usecase.GetCharacterByIdUC
import com.jorgeSM.apimarvel.presentation.mapper.transformToVO
import com.jorgeSM.apimarvel.presentation.modelVO.ResultVO
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

/*****
 * Projecto: Api marvel
 * From: com.jorgeSM.apimarvel.viewmodel
 * Create by Jorge S. Medina on 9/9/22 at 10:32
 * More info: https://www.linkedin.com/in/jorge-s%C3%A1nchez-medina-bb7b7371/
 *****/
class DetailsViewModel(
    private val getCharacterByIdUC: GetCharacterByIdUC = GetCharacterByIdUC()
) : ViewModel() {

    private val _character = MutableLiveData<ResultVO>()
    val character: LiveData<ResultVO> get() = _character

    private var requestJob: Job? = null

    fun getCharacterById(id: String, hash: String) {

        requestJob?.cancel()
        requestJob = viewModelScope.launch(Dispatchers.IO) {
            getCharacterByIdUC(
                CharacterItemByIdRequest(id, hash)
            )?.let {
                it.data?.results?.map { result ->
                    _character.postValue(result.transformToVO())
                }
            }
        }
    }
}