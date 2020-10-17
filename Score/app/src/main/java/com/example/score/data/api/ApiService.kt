package com.example.score.data.api

import com.example.score.data.models.Team
import com.example.score.data.models.TeamResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("/teams/league/2")
    suspend fun getAllTeams() : Response<TeamResponse>

    @GET("/teams/{team_id}")
    suspend fun getTeam(@Path("team_id") team_id: Int) : Response<Team>
}