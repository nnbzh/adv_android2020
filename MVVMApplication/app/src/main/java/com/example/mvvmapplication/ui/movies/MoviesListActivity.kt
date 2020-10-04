package com.example.mvvmapplication.ui.movies

import MovieAdapter
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvvmapplication.R
import com.example.mvvmapplication.data.model.Movie
import com.example.mvvmapplication.ui.common.State
import com.example.mvvmapplication.ui.common.ViewModelProviderFactory
import com.example.mvvmapplication.ui.detail.MovieDetailsActivity
import kotlinx.android.synthetic.main.activity_movies_list.*
import org.koin.android.viewmodel.ext.android.viewModel


class MoviesListActivity : AppCompatActivity(), MovieAdapter.RvItemClickListener {

    private val moviesListViewModel by viewModel<MoviesListViewModel>()
    private var adapter: MovieAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movies_list)


        bindRefresh()
        initAdapter()
        getMovies()
    }


    private fun initAdapter() {
        recycler_view.layoutManager = LinearLayoutManager(this)
        adapter = MovieAdapter(itemClickListener = this)
        recycler_view.adapter = adapter
    }

    private fun bindRefresh() {
        swipeRefreshLayout.setOnRefreshListener {
            adapter?.clearAll()
            getMovies()
        }
    }

    private fun getMovies() {
        moviesListViewModel.loadMovies()
        moviesListViewModel.state.observe(this, Observer {result ->
            when(result) {
                is State.ShowLoading -> {
                    swipeRefreshLayout.isRefreshing = true
                }
                is State.HideLoading -> {
                    swipeRefreshLayout.isRefreshing = false
                }
                is State.Success -> {
                    adapter?.movies = moviesListViewModel.moviesList.value
                    adapter?.notifyDataSetChanged()
                }
            }
        } )
    }

    override fun itemClick(position: Int, movie: Movie) {
        val intent = Intent(this, MovieDetailsActivity::class.java)
        intent.putExtra("movie_id", movie.id)
        startActivity(intent)
    }
}