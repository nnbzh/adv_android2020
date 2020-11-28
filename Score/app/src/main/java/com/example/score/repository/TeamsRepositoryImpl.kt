package com.example.score.repository

import com.example.score.data.api.ApiService
import com.example.score.data.models.ApiResponse
import com.example.score.data.models.Team
import com.example.score.utils.ApiStatus
import com.example.score.utils.RequestHandler
import java.lang.Exception

class TeamsRepositoryImpl(private val apiService: ApiService): TeamsRepository {

    override suspend fun getAllTeams(): ApiStatus<ApiResponse> {
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
}