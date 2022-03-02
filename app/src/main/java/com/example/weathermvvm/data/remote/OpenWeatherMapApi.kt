package com.example.weathermvvm.data.remote

import com.example.weathermvvm.data.remote.dto.PeriodDto
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface OpenWeatherMapApi {

    @GET("data/2.5/onecall?")
    suspend fun getWeather(
        @Query("lat") lat: String,
        @Query("lon") lon: String,
        @Query("exclude") exclude: String = "current,minutely,hourly",
        @Query("appid") appid: String = "86ba71f16b2a471617575a7e849aaba7"
    ): PeriodDto

}