package com.example.weathermvvm.presentation.weather_screen.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import com.example.weathermvvm.domain.model.Daily

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ListWithHeader(items: List<Daily>) {
    /*items.first().dt = "Today"
    LazyColumn {
        items(items) { item ->
            OneDayItem(item)
        }
    }*/
}