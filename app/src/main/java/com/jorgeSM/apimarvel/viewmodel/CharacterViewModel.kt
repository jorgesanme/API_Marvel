package com.jorgeSM.apimarvel.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jorgeSM.apimarvel.presentation.mapper.transformToVO
import com.jorgeSM.apimarvel.presentation.modelVO.ResultVO
import com.jorgeSM.apimarvel.remote.MarvelApi
import com.jorgeSM.apimarvel.utils.Const
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class CharacterViewModel : ViewModel() {

    private val _characterList = MutableLiveData<List<ResultVO>>()
    val characterList: LiveData<List<ResultVO>> get() = _characterList

    private val _character = MutableLiveData<ResultVO>()
    val character: LiveData<ResultVO> get() = _character

    private var api: MarvelApi
    private var requestJob: Job? = null


    init {
        val client = OkHttpClient().newBuilder().build()
        val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
        val retrofit = Retrofit.Builder()
            .baseUrl(Const.BASE_URL)
            .client(client)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
        api = retrofit.create(MarvelApi::class.java)
    }

    fun getCharacterList(hash: String) {
        requestJob?.cancel()
        requestJob = viewModelScope.launch(Dispatchers.IO) {
            val response = api.getCharacterList(
                Const.TIME_STAMP.toString(),
                Const.API_PUBLIC_KEY,
                hash
            )
            withContext(Dispatchers.Main) {
                val list = mutableListOf<ResultVO>()
                response?.data?.results?.map { result ->
                    list.add(result.transformToVO())
                }
                _characterList.postValue(list)
            }
        }
    }

    fun getCharacterById(id: String, hash: String) {
        requestJob?.cancel()
        requestJob = viewModelScope.launch(Dispatchers.IO) {
            val response = api.geCharacterById(
                id,
                Const.TIME_STAMP.toString(),
                Const.API_PUBLIC_KEY,
                hash
            )
            withContext(Dispatchers.Main) {
                var resultV0 = ResultVO()
                response?.data?.results?.map {
                    resultV0 = it.transformToVO()
                }
                _character.postValue(resultV0)
            }
        }
    }
}