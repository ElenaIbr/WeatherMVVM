package com.example.weathermvvm.presentation.weather_screen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.weathermvvm.R
import com.example.weathermvvm.domain.model.Daily
import com.example.weathermvvm.presentation.ui.theme.BackgroundDay

@Composable
fun DayDetailScreen(
    day: Daily,
    navController: NavController
) {
        Scaffold(
            topBar = {
                Row (
                    Modifier
                        .height(dimensionResource(id = R.dimen.scaffold_height))
                        .padding(dimensionResource(id = R.dimen.scaffold_padding))
                ) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = "Back",
                        modifier = Modifier
                            .clickable { navController.popBackStack() }
                    )
                    Text(
                        text = day.dt,
                        Modifier
                            .fillMaxWidth()
                            .padding(start = dimensionResource(id = R.dimen.scaffold_text_padding)),
                        textAlign = TextAlign.Center,
                        fontSize = 18.sp,
                    )
                }
            },
            backgroundColor = BackgroundDay) {
            Column(modifier = Modifier
                .fillMaxSize()
                .background(BackgroundDay)
            )
            {

            DetailWeather(day, true)
            DayDetailItem(
                stringResource(id = R.string.pressure),
                R.drawable.ic_pressure,
                day.pressure.toString()
            )
            DayDetailItem(
                stringResource(id = R.string.wind_speed),
                R.drawable.ic_wind ,
                day.windSpeed.toString()
            )
            DayDetailItem(
                stringResource(id = R.string.clouds),
                R.drawable.ic_clouds ,
                day.clouds.toString()
            )
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
            .padding(top = dimensionResource(id = R.dimen.day_detail_item_padding)),
        Arrangement.Start
    ) {
        Image(painter = painterResource(
            id = icon
        ),
            contentDescription = null,
            Modifier
                .height(
                    dimensionResource(id = R.dimen.day_detail_height)
                )
                .padding(start = dimensionResource(id = R.dimen.day_detail_item_padding))
        )

        Text (
            text = title + stringResource(id = R.string.colon) + value,
            Modifier
                .height(
                    dimensionResource(id = R.dimen.day_detail_height)
                )
                .padding(start = dimensionResource(id = R.dimen.day_detail_item_padding)),
            fontWeight = FontWeight.Medium
        )
    }

}