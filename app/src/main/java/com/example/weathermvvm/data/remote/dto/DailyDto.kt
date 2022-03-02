package com.example.weathermvvm.data.remote.dto

import com.example.weathermvvm.domain.model.Daily
import com.example.weathermvvm.utilits.getDate
import com.google.gson.annotations.SerializedName

data class DailyDto(
    @SerializedName("dt")
    val dt : Int,
    @SerializedName("sunrise")
    val sunrise : Int,
    @SerializedName("sunset")
    val sunset : Int,
    @SerializedName("moonrise")
    val moonrise : Int,
    @SerializedName("moonset")
    val moonset : Int,
    @SerializedName("moon_phase")
    val moonPhase : Double,
    @SerializedName("temp")
    val tempDto : TempDto,
    @SerializedName("feels_like")
    val feelsLike : FeelsLikeDto,
    @SerializedName("pressure")
    val pressure : Int,
    @SerializedName("humidity")
    val humidity : Int,
    @SerializedName("dew_point")
    val dewPoint : Double,
    @SerializedName("wind_speed")
    val windSpeed : Double,
    @SerializedName("wind_deg")
    val windDeg : Int,
    @SerializedName("wind_gust")
    val windGust : Double,
    @SerializedName("weather")
    val weatherDto : List<WeatherDto>,
    @SerializedName("clouds")
    val clouds : Int,
    @SerializedName("pop")
    val pop : Int,
    @SerializedName("uvi")
    val uvi : Double
)

fun DailyDto.toDaily(): Daily {
    return Daily(
        dt = dt.getDate(),
        moonrise = moonrise.getDate(),
        moonset = moonset.getDate(),
        temp = tempDto.toTemp(),
        weather = weatherDto.map{ it.toWeather() }
    )
}