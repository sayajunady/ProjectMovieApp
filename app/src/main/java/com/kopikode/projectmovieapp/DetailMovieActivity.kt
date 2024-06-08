package com.kopikode.projectmovieapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bumptech.glide.Glide
import com.kopikode.projectmovieapp.databinding.ActivityDetailMovieBinding
import com.kopikode.projectmovieapp.model.Movie

class DetailMovieActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_MOVIES = "extra_movies"
    }

    private lateinit var binding: ActivityDetailMovieBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailMovieBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        binding.imgItemPhoto.clipToOutline = true

        val detailMovies = intent.getParcelableExtra<Movie>(EXTRA_MOVIES)

        if (detailMovies != null) {
            val IMAGE_BASE = "https://image.tmdb.org/t/p/w500/"
            Glide.with(this).load(IMAGE_BASE + detailMovies.poster).into(binding.imgItemPhoto)
            binding.tvItemName.text = detailMovies.title
            binding.tvItemDescription.text = detailMovies.overview
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}