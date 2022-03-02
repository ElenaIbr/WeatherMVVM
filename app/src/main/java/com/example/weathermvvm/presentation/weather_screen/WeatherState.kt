package com.example.weathermvvm.presentation.weather_screen

import com.example.weathermvvm.domain.model.Period

data class WeatherState(
    val isLoafing: Boolean = false,
    val weather: Period? = null,
    val error: String = ""
)