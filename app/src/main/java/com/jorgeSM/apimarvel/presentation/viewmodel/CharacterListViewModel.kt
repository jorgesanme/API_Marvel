package com.jorgeSM.apimarvel.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jorgeSM.apimarvel.domain.models.ListOfCharacterRequest
import com.jorgeSM.apimarvel.domain.usecase.GetCharacterListUC
import com.jorgeSM.apimarvel.presentation.mapper.transformToVO
import com.jorgeSM.apimarvel.presentation.modelVO.ResultVO
import com.jorgeSM.apimarvel.utils.Utils
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class CharacterListViewModel(
    private val characterListUC: GetCharacterListUC = GetCharacterListUC()
) : ViewModel() {

    private val _state = MutableStateFlow( UiState())
    val state: StateFlow<UiState> = _state.asStateFlow()
    init {
        refresh()
    }

    private fun refresh() {
        viewModelScope.launch {
            _state.value = UiState(loading = true)
        }
        getCharacterList(Utils.createEndPointHash())
    }

    private var requestJob: Job? = null

    fun getCharacterList(hash: String){
        requestJob?.cancel()
        val list1 = mutableListOf<ResultVO>()
        requestJob = viewModelScope.launch(Dispatchers.IO) {
            val characterList = characterListUC(
                ListOfCharacterRequest(hash)
            )
            characterList.map {
                it?.data?.results?.map { result ->
                    list1.add(result.transformToVO())
                }
                _state.value = UiState(characters = list1)
            }

        }
    }

    fun onNavigationDone() {
       _state.value = _state.value.copy(navigateTo = null)
    }
}

data class UiState(
    val loading: Boolean = false,
    val characters: List<ResultVO>? = null,
    val navigateTo: ResultVO? = null

)