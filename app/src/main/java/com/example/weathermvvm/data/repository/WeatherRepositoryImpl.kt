package com.example.weathermvvm.data.repository

import com.example.weathermvvm.data.remote.OpenWeatherMapApi
import com.example.weathermvvm.data.remote.dto.PeriodDto
import com.example.weathermvvm.domain.repository.WeatherRepository
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(
    private val api: OpenWeatherMapApi
): WeatherRepository {
    override suspend fun getWeather(lat: String, lon: String): PeriodDto {
        return api.getWeather(lat, lon)
    }
}