package com.example.weathermvvm.domain.model

import com.google.gson.annotations.SerializedName

data class Daily(
    var dt: String,
    val moonrise: String,
    val moonset: String,
    val temp: Temp,
    val weather: List<Weather>
)