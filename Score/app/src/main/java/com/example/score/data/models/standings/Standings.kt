package com.example.score.data.models.standings

import com.google.gson.annotations.SerializedName

data class Standings (
    @SerializedName("results") val itemCount: Int,
    @SerializedName("standings") val standings: List<List<Standing>>,
)
