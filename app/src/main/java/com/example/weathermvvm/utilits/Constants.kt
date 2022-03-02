package com.example.weathermvvm.utilits

import com.example.weathermvvm.R
import java.text.SimpleDateFormat
import java.util.*

object Constants {
    const val BASE_URL = "https://api.openweathermap.org/"
    const val PARAM_LAT = "lat"
    const val PARAM_LON = "lon"
}

fun Double.toCelsius(): String {
    return if (this < 0) "-" + (this - 273.15).toInt().toString() + "℃"
    else (this - 273.15).toInt().toString() + "℃"
}

fun Int.getDate(): String {
    val sdf = SimpleDateFormat("EEEE, MMMM d", Locale.ENGLISH)
    val date = Date(this.toLong() * 1000)
    return sdf.format(date)
}

fun getImage(id: Int): Int {

    val code = id.toString().first()
    var image = 0

    when (code) {
        '2' -> image = R.drawable.ic_thunder
        '3' -> image = R.drawable.ic_drizzle
        '5' -> image = R.drawable.ic_rainy
        '6' -> image = R.drawable.ic_snow
        '7' -> image = R.drawable.ic_fog
    }

    when(id) {
        800 -> image = R.drawable.ic_clear
        801 -> image = R.drawable.ic_cloudy_day
        802 -> image = R.drawable.ic_cloudy_day
        803 -> image = R.drawable.ic_cloudy
        804 -> image = R.drawable.ic_cloudy
    }

    return image
}