package com.example.mvvmapplication.ui.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.mvvmapplication.R
import com.example.mvvmapplication.databinding.ActivityMovieDetailsBinding
import com.example.mvvmapplication.ui.common.ViewModelProviderFactory
import kotlinx.android.synthetic.main.activity_movie_details.*

class MovieDetailsActivity : AppCompatActivity() {
    
    private lateinit var movieDetailsViewModel: MovieDetailsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val bindingImpl:ActivityMovieDetailsBinding = DataBindingUtil
            .setContentView(this, R.layout.activity_movie_details)

        initViewModel()
        bindingImpl.lifecycleOwner = this


        val movieId = intent.getIntExtra("movie_id", 1)

        getMovie(movieId)
        bindingImpl.movie = movieDetailsViewModel.movie.value
    }

    private fun initViewModel() {
        movieDetailsViewModel = ViewModelProvider(this, ViewModelProviderFactory(this))
            .get(MovieDetailsViewModel::class.java)
    }

    private fun getMovie(movieId: Int) {
        movieDetailsViewModel.loadMovie(movieId)
    }
}