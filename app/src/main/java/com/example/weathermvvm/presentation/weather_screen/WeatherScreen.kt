package com.example.weathermvvm.presentation.weather_screen.components

import android.annotation.SuppressLint
import android.content.Context
import android.location.Location
import android.os.Looper
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.weathermvvm.R
import com.example.weathermvvm.presentation.Screen
import com.example.weathermvvm.presentation.ui.theme.BackgroundNight
import com.example.weathermvvm.presentation.ui.theme.TransparentBlue
import com.example.weathermvvm.presentation.weather_screen.WeatherViewModel
import com.example.weathermvvm.utilits.toJson
import com.google.android.gms.location.*



@Composable
fun WeatherScreen(
    viewModel: WeatherViewModel = hiltViewModel(),
    navController: NavController
) {
    val state = viewModel.state.value


    Column(Modifier
        .fillMaxSize()
    ) {

        state.weather.let { weather ->
            if (weather != null) {
                Text(
                    text = weather.timezone.toString(),
                    Modifier
                        .fillMaxWidth()
                        .padding(
                            start = dimensionResource(id = R.dimen.timezone_padding)
                        )
                        .background(TransparentBlue),
                    textAlign = TextAlign.Start,
                    fontSize = 12.sp,
                )
                weather.daily?.first()?.let { DetailWeather(today = it) }
            }
        }

        state.weather?.daily?.let { items ->
            items.first().dt = stringResource(id = R.string.today)

            LazyColumn {
                items(items) { item ->
                    OneDayItem(item, onItemClick = {
                        val dayString = it.toJson()
                        navController.navigate(Screen.DayDetailScreen.route + "/${dayString}")
                    })
                }
            }
        }
    }
    if(state.error.isNotBlank()) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            Text(
                text = state.error,
                color = BackgroundNight,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = dimensionResource(id = R.dimen.error_padding))
            )
        }
    }
    if(state.isLoafing) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            CircularProgressIndicator(color = BackgroundNight)
        }
    }

}

