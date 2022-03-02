package com.example.weathermvvm.presentation.weather_screen

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weathermvvm.domain.usecase.get_weather.GetWeatherUseCase
import com.example.weathermvvm.utilits.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class WeatherViewModel @Inject constructor(
    private val getWeatherUseCase: GetWeatherUseCase
): ViewModel() {

    private val _state = mutableStateOf(WeatherState())
    val state: State<WeatherState> = _state


    init {
        getWeather("52.0376977", "4.312")
    }


    private fun getWeather(lat: String, lon: String) {
        getWeatherUseCase(lat, lon).onEach { result ->
            when(result) {
                is Resource.Success -> {
                    _state.value = WeatherState(weather = result.data)
                }
                is Resource.Error -> {
                    _state.value = WeatherState(error = result.message ?: "An unexpected error")
                }
                is Resource.Loading -> {
                    _state.value = WeatherState(isLoafing = true)
                }
            }

        }.launchIn(viewModelScope)
    }

}