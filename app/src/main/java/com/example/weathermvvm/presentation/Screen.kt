package com.example.weathermvvm.presentation

sealed class Screen(val route: String) {
    object WeatherScreen: Screen("weather_screen")
    object DayDetailScreen: Screen("day_detail_screen")
}
