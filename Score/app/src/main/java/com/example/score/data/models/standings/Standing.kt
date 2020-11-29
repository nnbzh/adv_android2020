package com.example.score.data.models.standings

import com.google.gson.annotations.SerializedName

data class Standing(
    @SerializedName("rank") val rank: Int,
    @SerializedName("teamName") val teamName: String,
    @SerializedName("logo") val logoUrl: String,
    @SerializedName("description") val promotion: String,
    @SerializedName("all") val all: MatchSummary,
    @SerializedName("home") val home: MatchSummary,
    @SerializedName("away") val away: MatchSummary,
    @SerializedName("points") val pts: Int,
    @SerializedName("goalsDiff") val goalsDiff: Int
)
