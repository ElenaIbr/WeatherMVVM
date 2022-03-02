package com.example.weathermvvm

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.weathermvvm.presentation.ui.theme.WeatherMVVMTheme
import com.example.weathermvvm.presentation.weather_screen.components.RequestPermission
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @ExperimentalPermissionsApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WeatherMVVMTheme (darkTheme = true) {
                RequestPermission()
            }
        }
    }
}