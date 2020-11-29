package com.example.score.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.score.data.models.standings.Standing
import com.example.score.repository.TeamsRepository
import com.example.score.utils.ApiStatus
import kotlinx.coroutines.launch

class StandingsViewModel(private val teamsRepository: TeamsRepository): BaseViewModel() {

    private val _standings = MutableLiveData<List<Standing>>()
    val standings: LiveData<List<Standing>> = _standings

    fun loadStandings() {
        viewModelScope.launch {
            showLoading = true
            when (val result = teamsRepository.getStandings()) {
                is ApiStatus.Success -> {
                    _standings.value = result.data.api.standings[0]
                    showLoading = false
                }
                is ApiStatus.Error -> {
                    showLoading = false
                }
            }
        }
    }
}