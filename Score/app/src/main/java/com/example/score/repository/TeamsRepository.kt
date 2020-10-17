package com.example.score.repository

import com.example.score.data.models.Team
import com.example.score.data.models.TeamResponse
import com.example.score.utils.ApiStatus

interface TeamsRepository {

    suspend fun getAllTeams() : ApiStatus<TeamResponse>
    suspend fun getTeam(id: Int) : ApiStatus<List<Team>>
}