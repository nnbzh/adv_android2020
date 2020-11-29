package com.example.score.data.models.standings

import com.google.gson.annotations.SerializedName

data class MatchSummary(
    @SerializedName("matchsPlayed") val matchesPlayed: Int,
    @SerializedName("win") val win: Int,
    @SerializedName("draw") val draw: Int,
    @SerializedName("lose") val lose: Int,
    @SerializedName("goalsFor") val goalsFor: Int,
    @SerializedName("goalsAgainst") val goalsAgainst: Int,
)