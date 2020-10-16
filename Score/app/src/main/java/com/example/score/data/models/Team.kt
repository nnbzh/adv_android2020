package com.example.score.data.models

import com.google.gson.annotations.SerializedName

data class Team(
    @SerializedName("team_id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("logo") val imageUrl: String,
    @SerializedName("country") val country: String,
    @SerializedName("venue_name") val stadium: String,
    @SerializedName("venue_city") val city: String,
    @SerializedName("venue_capacity") val stadiumCapacity: Int
)
