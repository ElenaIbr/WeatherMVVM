package com.example.weathermvvm.presentation.weather_screen.components

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModel
import com.example.weathermvvm.presentation.weather_screen.WeatherViewModel

@Composable
fun WeatherScreen(
    viewModel: WeatherViewModel = hiltViewModel()
) {
    val state = viewModel.state.value

    state.let {
        state.weather?.let { it1 -> Text(text = it1.timezone) }
    }

}