package com.example.weathermvvm.domain.repository

import com.example.weathermvvm.data.remote.dto.PeriodDto

interface WeatherRepository {
    suspend fun getWeather(lat: String, lon: String) : PeriodDto
}