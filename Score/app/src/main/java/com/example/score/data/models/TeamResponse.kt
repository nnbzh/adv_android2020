package com.example.score.data.models

import com.google.gson.annotations.SerializedName

data class TeamResponse(
    @SerializedName("teams") val teams: List<Team>
)