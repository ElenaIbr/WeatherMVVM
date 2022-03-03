package com.example.weathermvvm.presentation.weather_screen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weathermvvm.R
import com.example.weathermvvm.domain.model.Daily
import com.example.weathermvvm.domain.model.Period
import com.example.weathermvvm.presentation.Screen
import com.example.weathermvvm.presentation.ui.theme.BackgroundSunRiseSet
import com.example.weathermvvm.presentation.ui.theme.TransparentBlue
import com.example.weathermvvm.utilits.toJson

@Composable
fun DetailWeather(today: Daily) {
    Column (
        modifier = Modifier
            .fillMaxWidth()
            .background(TransparentBlue)
    ) {
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
                    textAlign = TextAlign.Center,
                    fontSize = 18.sp)

                Text(text = "Morning\n" + temperature?.morn.toString(),
                    textAlign = TextAlign.Center,
                    fontSize = 18.sp)

                Text(text = "Day\n" + temperature?.day.toString(),
                    textAlign = TextAlign.Center,
                    fontSize = 18.sp)

                Text(text = "Evening\n" + temperature?.eve.toString(),
                    textAlign = TextAlign.Center,
                    fontSize = 18.sp)
            }
        }

        Row (
            Modifier
                .fillMaxWidth()
                .background(BackgroundSunRiseSet)
                .clip(RoundedCornerShape(10.dp)),
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Text(text = "Sunrise\n" + today?.sunrise,
                Modifier.padding(start = 30.dp),
                textAlign = TextAlign.Center)

            Image(painter = painterResource(
                id = R.drawable.ic_sunset_sunrise
            ),
                contentDescription = null,
                Modifier
                    .width(120.dp)
                    .fillMaxWidth()
                    .padding(12.dp)
            )

            Text(text = "Sunset\n" + today?.sunset,
                Modifier.padding(end = 30.dp),
                textAlign = TextAlign.Center)

        }
    }
}