package com.example.score.data.models.standings

import com.google.gson.annotations.SerializedName

data class StandingsResponse(
    @SerializedName("api") val api: Standings
)