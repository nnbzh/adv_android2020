package com.example.score.data.models

import com.google.gson.annotations.SerializedName


data class Teams(
    @SerializedName("results") val itemCount: Int,
    @SerializedName("teams") val teams: List<Team>,
)