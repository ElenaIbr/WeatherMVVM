package com.example.weathermvvm.presentation.weather_screen.components

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.weathermvvm.presentation.weather_screen.WeatherViewModel
import com.example.weathermvvm.utilits.getImage
import androidx.compose.ui.res.stringResource

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
                .padding(top = 16.dp)
        ) {
            Text(
                text = weather?.timezone.toString(),
                Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp),
                textAlign = TextAlign.Center
            )


            Text(
                text = today?.dt.toString(),
                Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp),
                textAlign = TextAlign.Center
            )

            today?.temp?.let {
                Text(
                    text = it.day,
                    Modifier
                        .fillMaxWidth(),
                    textAlign = TextAlign.Center,
                    fontSize = 46.sp
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

}