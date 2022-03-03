package com.example.weathermvvm

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.weathermvvm.domain.model.Daily
import com.example.weathermvvm.presentation.Screen
import com.example.weathermvvm.presentation.ui.theme.WeatherMVVMTheme
import com.example.weathermvvm.presentation.weather_screen.components.DayDetailScreen
import com.example.weathermvvm.presentation.weather_screen.components.RequestPermission
import com.example.weathermvvm.presentation.weather_screen.components.WeatherScreen
import com.example.weathermvvm.utilits.fromJson
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @ExperimentalPermissionsApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WeatherMVVMTheme (darkTheme = true) {
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = Screen.WeatherScreen.route
                ) {
                    composable(
                        route = Screen.WeatherScreen.route
                    ) {
                        WeatherScreen(navController = navController)
                    }
                    composable(
                        route = Screen.DayDetailScreen.route + "/{item}",
                        arguments = listOf(navArgument("item") {
                            type = NavType.StringType
                        })
                    ) {
                        it.arguments?.getString("item")?.let { jsonString ->
                            val day = jsonString.fromJson(Daily::class.java)
                            DayDetailScreen( day = day , navController = navController )
                        }
                    }
                }
                //RequestPermission()
            }
        }
    }
}
