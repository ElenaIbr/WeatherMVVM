package com.example.weathermvvm.presentation.weather_screen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.weathermvvm.domain.model.Daily
import com.example.weathermvvm.presentation.ui.theme.BackgroundDay
import com.example.weathermvvm.utilits.getImage
import java.util.*

@Composable
fun OneDayItem(day: Daily,
               onItemClick: (Daily) -> Unit
) {

    Divider(color = Color.Transparent, thickness = 3.dp)

    Row (
        Modifier
            .fillMaxSize()
            .clip(RoundedCornerShape(20))
            .background(BackgroundDay)
            .padding(start = 16.dp, end = 16.dp)
            .clickable { onItemClick(day) }
    ) {
        Image(painter = painterResource(
            id = getImage(day.weather.first().id)
        ),
            contentDescription = null,
            Modifier
                .width(100.dp)
        )

        Column(Modifier
            .fillMaxHeight()
            .padding(top = 5.dp),
            verticalArrangement = Arrangement.Center
        ) {
            Text (
                text = day.dt + ", " + day.temp.day,
                fontWeight = FontWeight.Medium
            )
            Text (
                text = day.weather.first().description.replaceFirstChar {
                    if (it.isLowerCase()) it.titlecase(
                        Locale.getDefault()
                    ) else it.toString()
                }
            )
        }
    }

}