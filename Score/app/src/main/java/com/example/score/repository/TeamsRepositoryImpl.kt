package com.example.score.repository

import android.util.Log
import com.example.score.data.api.ApiService
import com.example.score.data.models.standings.StandingsResponse
import com.example.score.data.models.TeamsResponse
import com.example.score.data.models.Team
import com.example.score.utils.ApiStatus
import com.example.score.utils.RequestHandler
import java.lang.Exception

class TeamsRepositoryImpl(private val apiService: ApiService): TeamsRepository {

    override suspend fun getAllTeams(): ApiStatus<TeamsResponse> {
        return try {
            val response = apiService.getAllTeams()
            if (response.isSuccessful) {
                    RequestHandler.handleSuccess(response)
            } else {
                RequestHandler.handleSuccess(response)
            }
        } catch (e:Exception) {
            return ApiStatus.Error(e)
        }
    }

    override suspend fun getTeam(id: Int): ApiStatus<List<Team>> {
        TODO("Not yet implemented")
    }

    override suspend fun getStandings(): ApiStatus<StandingsResponse> {
        return try {
            val response = apiService.getStandings()
            if (response.isSuccessful) {
                RequestHandler.handleSuccess(response)
            } else {
                RequestHandler.handleSuccess(response)
            }
        } catch (e: Exception) {
            return ApiStatus.Error(e)
        }
    }

}