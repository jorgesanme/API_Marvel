package com.jorgeSM.apimarvel.presentation.activity

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.jorgeSM.apimarvel.R
import com.jorgeSM.apimarvel.databinding.ActivityMainBinding
import com.jorgeSM.apimarvel.presentation.adapter.CharacterAdapter
import com.jorgeSM.apimarvel.presentation.mapper.transformToVO
import com.jorgeSM.apimarvel.presentation.modelVO.ResultVO
import com.jorgeSM.apimarvel.remote.MarvelApi
import com.jorgeSM.apimarvel.utils.Const
import com.jorgeSM.apimarvel.utils.Utils
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var characterList: MutableList<ResultVO>
    private lateinit var mAdapter: CharacterAdapter
    private lateinit var linearLayoutManager: LinearLayoutManager


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).also { binding ->
            setContentView(binding.root)
        }

        llamadaAPI()


    }


    private fun llamadaAPI() {
        // FIXME: extraer al VeiwModel
        characterList = mutableListOf()

        GlobalScope.launch(Dispatchers.IO) {
            val client = OkHttpClient().newBuilder().build()
            val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
            val retrofit = Retrofit.Builder()
                .baseUrl(Const.BASE_URL)
                .client(client)
                .addConverterFactory(MoshiConverterFactory.create(moshi))
                .build()
            val api: MarvelApi = retrofit.create(MarvelApi::class.java)

            val response = api.getCharacterList(
                "1",
                Const.API_PUBLIC_KEY,
                createEndPointHash()
            )

            Log.d("Response", response.toString())

            withContext(Dispatchers.Main) {

                response?.data?.results?.map { result ->
                    characterList.add(
                        result.transformToVO()
                    )

                }
                setupRecycleView(characterList)
            }

            Log.i("lista", characterList.toString())

        }

    }

    /*trasladar al ViewModel*/
    private fun createMD5(input: String): String {
        val hash = Utils.createMD5(input)
        Log.i("Hash", hash)
        return hash
    }

    /*trasladar al ViewModel*/
    private fun createEndPointHash(): String =
        createMD5(
            Const.TIME_STAMP.toString()
                    + getString(R.string.private_api_key)
                    + Const.API_PUBLIC_KEY
        )


    private fun setupRecycleView(list: List<ResultVO>) {
        mAdapter = CharacterAdapter(list)
        linearLayoutManager = LinearLayoutManager(this)

        binding.rvCharacters.apply {
            setHasFixedSize(true)
            layoutManager = linearLayoutManager
            adapter = mAdapter
        }
    }


}