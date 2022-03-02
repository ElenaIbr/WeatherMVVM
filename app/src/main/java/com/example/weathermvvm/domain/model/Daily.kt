package com.example.weathermvvm.domain.model

import com.google.gson.annotations.SerializedName

data class Daily(
    val dt: Int,
    val moonrise: Int,
    val moonset: Int,
    val temp: Temp,
    val weather: List<Weather>
)