package com.example.weathermvvm.presentation.weather_screen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weathermvvm.R
import com.example.weathermvvm.domain.model.Daily
import com.example.weathermvvm.presentation.ui.theme.BackgroundNight
import com.example.weathermvvm.presentation.ui.theme.BackgroundSunRiseSet
import com.example.weathermvvm.presentation.ui.theme.TransparentBlue

@Composable
fun DetailWeather(
    today: Daily,
    isDetail: Boolean = false
) {
    Column (
        modifier = Modifier
            .fillMaxWidth()
            .background(TransparentBlue)
    ) {
        if(!isDetail) {
            Text(
                text = today.dt,
                Modifier
                    .fillMaxWidth()
                    .padding(top = 24.dp),
                textAlign = TextAlign.Center,
                fontSize = 20.sp,
            )
        }
        today.temp.let { temperature ->
            Text(
                text = temperature.day,
                Modifier
                    .fillMaxWidth(),
                textAlign = TextAlign.Center,
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold
            )

            Row (
                Modifier
                    .fillMaxWidth()
                    .padding(24.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = stringResource(id = R.string.night) + temperature.night,
                    textAlign = TextAlign.Center,
                    fontSize = 16.sp)

                Text(text = stringResource(id = R.string.morning) + temperature.morn,
                    textAlign = TextAlign.Center,
                    fontSize = 16.sp)

                Text(text = stringResource(id = R.string.day) + temperature.day,
                    textAlign = TextAlign.Center,
                    fontSize = 16.sp)

                Text(text = stringResource(id = R.string.evening) + temperature.eve,
                    textAlign = TextAlign.Center,
                    fontSize = 16.sp)
            }
        }

        if(!isDetail) {
            Row (
                Modifier
                    .fillMaxWidth()
                    .background(BackgroundSunRiseSet)
                    .clip(RoundedCornerShape(10.dp)),
                horizontalArrangement = Arrangement.SpaceBetween)
            {
                Text(text = stringResource(id = R.string.sunrise) + today.sunrise,
                    Modifier
                        .padding(start = 30.dp),
                    textAlign = TextAlign.Center,
                    fontSize = 14.sp)

                Image(painter = painterResource(
                    id = R.drawable.ic_sunset_sunrise
                ),
                    contentDescription = null,
                    Modifier
                        .width(120.dp)
                        .fillMaxWidth()
                        .padding(12.dp)
                )
                Text(text = stringResource(id = R.string.sunset) + today.sunset,
                    Modifier.padding(
                        end = 30.dp
                    ),
                    textAlign = TextAlign.Center,
                    fontSize = 14.sp
                )
            }
        }
        Divider(color = BackgroundNight, thickness = 0.5.dp)
    }
}