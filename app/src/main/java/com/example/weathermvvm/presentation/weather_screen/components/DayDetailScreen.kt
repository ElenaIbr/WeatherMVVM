package com.example.weathermvvm.presentation.weather_screen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.navDeepLink
import com.example.weathermvvm.R
import com.example.weathermvvm.domain.model.Daily
import com.example.weathermvvm.presentation.ui.theme.BackgroundDay
import com.example.weathermvvm.presentation.ui.theme.BackgroundNight
import com.example.weathermvvm.presentation.ui.theme.TransparentBlue
import com.example.weathermvvm.utilits.getImage
import java.util.*

@Composable
fun DayDetailScreen(
    day: Daily,
    navController: NavController
) {






        Scaffold(
            topBar = {
                Row {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = "Back",
                        modifier = Modifier
                            .padding(16.dp)
                            .clickable {
                                navController.popBackStack()
                            }
                    )
                }
            },
            backgroundColor = BackgroundDay
        ) {
            Column(modifier = Modifier
                .fillMaxSize()
                .background(BackgroundDay)) {
            DetailWeather(day)
            DayDetailItem("Pressure", R.drawable.ic_pressure ,day.pressure.toString())

            DayDetailItem("Wind Speed", R.drawable.ic_wind ,day.windSpeed.toString())

            DayDetailItem("Clouds", R.drawable.ic_clouds ,day.clouds.toString())
                }
        }






}

@Composable
fun DayDetailItem(
    title: String,
    icon: Int,
    value: String
) {
    Row (
        Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Image(painter = painterResource(
            id = icon
        ),
            contentDescription = null,
            Modifier
                .width(64.dp)
        )

        Text (
            text = title + ": " + value,
            modifier = Modifier
                .padding(top = 16.dp, start = 64.dp),
            fontWeight = FontWeight.Medium
        )
    }

}