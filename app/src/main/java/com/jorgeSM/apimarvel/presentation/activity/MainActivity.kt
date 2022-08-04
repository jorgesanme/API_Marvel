package com.jorgeSM.apimarvel.presentation.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.jorgeSM.apimarvel.databinding.ActivityMainBinding
import com.jorgeSM.apimarvel.presentation.adapter.CharacterAdapter
import com.jorgeSM.apimarvel.presentation.modelVO.CharacterVO

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var characterList: MutableList<CharacterVO>
    private lateinit var mAdapter: CharacterAdapter
    private lateinit var linearLayoutManager: LinearLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).also { binding ->
            setContentView(binding.root)
        }
        setupList()
        setupRecycleView()
    }

    private fun setupList() {
        characterList = mutableListOf(
            CharacterVO(
                image = "https://images.pexels.com/photos/11220067/pexels-photo-11220067.jpeg",
                name = "Largo Winch"
            ),
            CharacterVO(
                image = "https://images.pexels.com/photos/3336004/pexels-photo-3336004.jpeg",
                name = "Corto Winch"
            ),
            CharacterVO(
                image = "https://images.pexels.com/photos/8332518/pexels-photo-8332518.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
                name = "Barba Winch"
            ),
            CharacterVO(
                image = "https://images.pexels.com/photos/12040386/pexels-photo-12040386.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
                name = "Brunette Winch"
            )
        )
    }

    private fun setupRecycleView() {
        mAdapter = CharacterAdapter(characterList)
        linearLayoutManager = LinearLayoutManager(this)

        binding.rvCharacters.apply {
            setHasFixedSize(true)
            layoutManager = linearLayoutManager
            adapter = mAdapter
        }
    }


}