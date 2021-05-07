package com.path_studio.moviecatalogue.ui.search

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.path_studio.moviecatalogue.R
import com.path_studio.moviecatalogue.databinding.ActivityDetailMovieBinding
import com.path_studio.moviecatalogue.databinding.ActivitySearchBinding
import com.path_studio.moviecatalogue.ui.mainPage.MainActivity

class SearchActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySearchBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySearchBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonBack.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}