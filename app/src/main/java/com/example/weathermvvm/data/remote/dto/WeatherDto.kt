package com.example.weathermvvm.data.remote.dto

import com.example.weathermvvm.domain.model.Weather

data class WeatherDto(
    val description: String,
    val icon: String,
    val id: Int,
    val main: String
)

fun WeatherDto.toWeather(): Weather {
    return Weather(
        id = id,
        description = description
    )
}