package com.example.mvvmapplication.ui.movies

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvvmapplication.data.API_KEY
import com.example.mvvmapplication.data.api.ApiClient
import com.example.mvvmapplication.data.api.PostApi
import com.example.mvvmapplication.data.model.Movie
import com.example.mvvmapplication.ui.common.State
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MoviesListViewModel(val postApi: PostApi) : ViewModel() {

    private val logTag = "MoviesListViewModel"

    private val _state = MutableLiveData<State>()
    val state: LiveData<State> = _state

    private val _moviesList = MutableLiveData<List<Movie>>()
    val moviesList: LiveData<List<Movie>> = _moviesList

    fun loadMovies() {
        _state.value = State.ShowLoading
        viewModelScope.launch {
            runCatching {
             withContext(Dispatchers.IO) {
                    postApi.getMoviesList(API_KEY)
                }
            }.onSuccess {
                _state.value = State.HideLoading
                _moviesList.value = it.body()?.movies
                _state.value = State.Success
            }.onFailure {
                _state.value = State.HideLoading
                Log.e(logTag, Log.getStackTraceString(it))
            }

        }

    }

}
