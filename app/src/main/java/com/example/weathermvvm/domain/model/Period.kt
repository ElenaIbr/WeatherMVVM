package com.example.weathermvvm.domain.model

data class Period(
    val daily: List<Daily>,
    val timezone: String
)