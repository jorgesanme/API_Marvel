package com.jorgeSM.apimarvel.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jorgeSM.apimarvel.domain.models.CharacterItemByIdRequest
import com.jorgeSM.apimarvel.domain.usecase.GetCharacterByIdUC
import com.jorgeSM.apimarvel.presentation.mapper.transformToVO
import com.jorgeSM.apimarvel.presentation.modelVO.ResultVO
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch


class DetailsViewModel(
    private val getCharacterByIdUC: GetCharacterByIdUC = GetCharacterByIdUC()
) : ViewModel() {

    private val _character = MutableStateFlow(DetailState())
    val character: StateFlow<DetailState> get() = _character.asStateFlow()

    private var requestJob: Job? = null

    init {
        refresh()
    }


    private fun refresh() =
        viewModelScope.launch {
            _character.value = DetailState(loading = true)
        }

    fun getCharacterById(id: String, hash: String) {
        requestJob?.cancel()
        requestJob = viewModelScope.launch(Dispatchers.IO) {
            getCharacterByIdUC(
                CharacterItemByIdRequest(id, hash)
            )?.let {
                it.data?.results?.map { result ->
                    _character.value =
                        DetailState(character = result.transformToVO(), loading = false)
                }
            }
        }
    }
}

data class DetailState(
    val loading: Boolean = false,
    val character: ResultVO? = null
)