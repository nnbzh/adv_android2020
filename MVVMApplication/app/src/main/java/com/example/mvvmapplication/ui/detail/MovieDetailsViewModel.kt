package com.example.mvvmapplication.ui.detail

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

class MovieDetailsViewModel(val postApi: PostApi) :ViewModel() {

    private val logTag = "MovieDetailsViewModel"

    private val _state = MutableLiveData<State>()
    val state: LiveData<State> = _state

    private val _movie = MutableLiveData<Movie>()
    val movie: LiveData<Movie> = _movie

    fun loadMovie(id: Int) {
        _state.value = State.ShowLoading
        viewModelScope.launch {
            runCatching {
                withContext(Dispatchers.IO) { postApi.getMovie(movieId = id, apiKey = API_KEY)
                }
            }.onSuccess {
                _state.value = State.HideLoading
                _movie.value = it.body()
                _state.value = State.Success
            }.onFailure {
                _state.value = State.HideLoading
                Log.e(logTag, Log.getStackTraceString(it))
            }

        }

    }
}