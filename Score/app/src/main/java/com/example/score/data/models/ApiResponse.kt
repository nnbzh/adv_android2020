package com.example.score.data.models

import com.google.gson.annotations.SerializedName

data class ApiResponse(
    @SerializedName("api") val api: ApiItem
)