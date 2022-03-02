package com.example.weathermvvm.presentation.weather_screen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.weathermvvm.presentation.ui.theme.BackgroundDay
import com.example.weathermvvm.presentation.ui.theme.TransparentBlue
import com.example.weathermvvm.presentation.weather_screen.WeatherViewModel

@Preview
@Composable
fun WeatherScreen(
    viewModel: WeatherViewModel = hiltViewModel()
) {
    val state = viewModel.state.value

    state.weather.let { weather ->
        val today = weather?.daily?.first()

        Column (
            modifier = Modifier
                .fillMaxSize()
                .background(TransparentBlue)
        ) {
            Text(
                text = weather?.timezone.toString(),
                Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp, start = 4.dp),
                textAlign = TextAlign.Start,
                fontSize = 12.sp
            )
            Text(
                text = today?.dt.toString(),
                Modifier
                    .fillMaxWidth()
                    .padding(top = 24.dp),
                textAlign = TextAlign.Center,
                fontSize = 28.sp,
            )
            today?.temp?.let {
                Text(
                    text = it.day,
                    Modifier
                        .fillMaxWidth(),
                    textAlign = TextAlign.Center,
                    fontSize = 46.sp,
                    fontWeight = FontWeight.Bold
                )
            }
            today?.temp.let { temperature ->
                Row (
                    Modifier
                        .fillMaxWidth()
                        .padding(24.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(text = "Night\n" + temperature?.night.toString(),
                        textAlign = TextAlign.Center)

                    Text(text = "Morning\n" + temperature?.morn.toString(),
                        textAlign = TextAlign.Center)

                    Text(text = "Day\n" + temperature?.day.toString(),
                        textAlign = TextAlign.Center)

                    Text(text = "Evening\n" + temperature?.eve.toString(),
                        textAlign = TextAlign.Center)
                }

            }
            weather?.daily?.let { ListWithHeader(it) }
        }

    }

    if(state.error.isNotBlank()) {
        Text(
            text = state.error,
            color = MaterialTheme.colors.error,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
        )
    }
    if(state.isLoafing) {
        CircularProgressIndicator(color = BackgroundDay)
    }

}