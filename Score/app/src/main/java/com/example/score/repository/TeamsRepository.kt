package com.example.score.repository

import com.example.score.data.models.ApiResponse
import com.example.score.data.models.Team
import com.example.score.utils.ApiStatus

interface TeamsRepository {

    suspend fun getAllTeams() : ApiStatus<ApiResponse>
    suspend fun getTeam(id: Int) : ApiStatus<List<Team>>
}