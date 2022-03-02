package com.example.weathermvvm.data.remote.dto

import com.example.weathermvvm.domain.model.Daily
import com.google.gson.annotations.SerializedName

data class DailyDto(
    val clouds: Int,
    @SerializedName("dew_point")
    val dewPoint: Double,
    val dt: Int,
    @SerializedName("feels_like")
    val feelsLikeDto: FeelsLikeDto,
    val humidity: Int,
    @SerializedName("moon_phase")
    val moonPhase: Int,
    val moonrise: Int,
    val moonset: Int,
    val pop: Int,
    val pressure: Int,
    val sunrise: Int,
    val sunset: Int,
    val tempDto: TempDto,
    val uvi: Double,
    val weatherDto: List<WeatherDto>,
    @SerializedName("wind_deg")
    val windDeg: Int,
    @SerializedName("wind_gust")
    val windGust: Double,
    @SerializedName("wind_speed")
    val windSpeed: Double
)

fun DailyDto.toDaily(): Daily {
    return Daily(
        dt = dt,
        moonrise = moonrise,
        moonset = moonset,
        temp = tempDto.toTemp(),
        weather = weatherDto.map{ it.toWeather() }
    )
}