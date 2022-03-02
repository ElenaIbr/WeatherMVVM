package com.example.weathermvvm.domain.model

data class Period(
    val timezone: String?,
    val daily: List<Daily>?
)