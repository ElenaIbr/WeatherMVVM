package com.example.weathermvvm.presentation.weather_screen.components

import android.content.res.Resources
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.SemanticsProperties.Text
import com.example.weathermvvm.domain.model.Daily
import androidx.compose.material.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.weathermvvm.R
import com.example.weathermvvm.presentation.ui.theme.TransparentWhite
import com.example.weathermvvm.utilits.getImage

@Composable
fun OneDayItem(day: Daily) {

    Divider(color = Color.Transparent, thickness = 3.dp)

    Row (
        Modifier
            .fillMaxSize()
            .clip(RoundedCornerShape(20))
            .background(TransparentWhite)
            .padding(start = 16.dp, end = 16.dp)
    ) {
        Image(painter = painterResource(id = getImage(day.weather.first().id)),
            contentDescription = null)

        Column(Modifier
            .fillMaxHeight()
            .padding(top = 5.dp),
            verticalArrangement = Arrangement.Center
        ) {
            Text (
                text = day.dt.toString(),
            )
            Text (
                text = day.temp.day.toString() + ", " + day.weather.first().description
            )
        }
    }

}