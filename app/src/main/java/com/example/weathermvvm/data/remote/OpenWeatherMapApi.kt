package com.example.weathermvvm.data.remote

import com.example.weathermvvm.data.remote.dto.PeriodDto
import retrofit2.http.GET
import retrofit2.http.Path

interface OpenWeatherMapApi {

    @GET("data/2.5/onecall?lat={lat}&lon={lon}&exclude=current,minutely,hourly&appid=86ba71f16b2a471617575a7e849aaba7")
    suspend fun getWeather(
        @Path("lat") lat: String,
        @Path("lon") lon: String
    ): PeriodDto

}