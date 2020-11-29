package com.example.score.repository

import com.example.score.data.models.standings.StandingsResponse
import com.example.score.data.models.TeamsResponse
import com.example.score.data.models.Team
import com.example.score.utils.ApiStatus

interface TeamsRepository {

    suspend fun getAllTeams() : ApiStatus<TeamsResponse>
    suspend fun getTeam(id: Int) : ApiStatus<List<Team>>
    suspend fun getStandings(): ApiStatus<StandingsResponse>
}