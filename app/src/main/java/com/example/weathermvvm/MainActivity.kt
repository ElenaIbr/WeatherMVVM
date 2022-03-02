package com.example.weathermvvm

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.weathermvvm.presentation.ui.theme.WeatherMVVMTheme
import com.example.weathermvvm.presentation.weather_screen.WeatherViewModel
import com.example.weathermvvm.presentation.weather_screen.components.WeatherScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val viewModel: WeatherViewModel = hiltViewModel()
            WeatherScreen(viewModel)
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    WeatherMVVMTheme {
        Greeting("Android")
    }
}