package com.jorgeSM.apimarvel.presentation.activity

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.jorgeSM.apimarvel.databinding.ActivityMainBinding
import org.kodein.di.DI
import org.kodein.di.DIAware
import org.kodein.di.android.di


class MainActivity : AppCompatActivity(), DIAware {
    private lateinit var binding: ActivityMainBinding

    override val di: DI by di()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).also { binding ->
            setContentView(binding.root)
        }
        setupToolbar()

    }

    private fun setupToolbar() {
        setSupportActionBar(binding.toolbar)
        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> onBackPressed()
        }
        return super.onOptionsItemSelected(item)

    }


}