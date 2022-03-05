package com.example.weathermvvm.data.remote.dto

import com.example.weathermvvm.domain.model.Period
import com.google.gson.annotations.SerializedName

data class PeriodDto(
    @SerializedName("daily")
    val dailyDto: List<DailyDto>?,
    val lat: Double?,
    val lon: Double?,
    val timezone: String?,
    @SerializedName("timezone_offset")
    val timezoneOffset: Int?
)

fun PeriodDto.toPeriod(): Period {
    return Period(
        daily = dailyDto?.map { it.toDaily() },
        timezone = timezone
    )
}


