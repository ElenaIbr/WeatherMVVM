package com.example.weathermvvm.domain.model

data class Daily(
    var dt: String,
    val sunrise: String,
    val sunset: String,
    val temp: Temp,
    val weather: List<Weather>,
    val pressure : Int,
    val clouds : Int,
    val windSpeed : Double
)