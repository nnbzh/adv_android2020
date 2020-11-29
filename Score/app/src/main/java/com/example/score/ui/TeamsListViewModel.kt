package com.example.score.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.score.data.models.Team
import com.example.score.repository.TeamsRepository
import com.example.score.utils.ApiStatus
import kotlinx.coroutines.launch

class TeamsListViewModel(private val teamsRepository: TeamsRepository): BaseViewModel() {

    private val _teams = MutableLiveData<List<Team>>()
    val teams: LiveData<List<Team>> = _teams

    fun loadTeams() {
        viewModelScope.launch {
            showLoading = true
            when (val result = teamsRepository.getAllTeams()) {
                    is ApiStatus.Success -> {
                        _teams.value = result.data.api.teams
                        showLoading = false
                    }
                    is ApiStatus.Error -> {

                    }
            }
        }
    }

  }