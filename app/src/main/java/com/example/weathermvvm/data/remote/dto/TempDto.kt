package com.example.weathermvvm.data.remote.dto

import com.example.weathermvvm.domain.model.Temp

data class TempDto(
    val day: Double,
    val eve: Double,
    val max: Double,
    val min: Double,
    val morn: Double,
    val night: Double
)

fun TempDto.toTemp(): Temp {
    return Temp(
        day = day,
        morn = morn,
        eve = eve,
        night = night
    )
}