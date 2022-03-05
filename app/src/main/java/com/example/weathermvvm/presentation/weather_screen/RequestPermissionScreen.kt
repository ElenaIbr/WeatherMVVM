package com.example.weathermvvm.presentation.weather_screen.components

import android.Manifest
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.navigation.NavController
import com.example.weathermvvm.R
import com.example.weathermvvm.presentation.ui.theme.BackgroundNight
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.rememberMultiplePermissionsState

@ExperimentalPermissionsApi
@Composable
fun RequestPermission(navController: NavController) {

    val permissionsState = rememberMultiplePermissionsState(
        permissions = listOf(
            Manifest.permission.ACCESS_COARSE_LOCATION,
            Manifest.permission.ACCESS_FINE_LOCATION,
        )
    )

    val lifecycleOwner = LocalLifecycleOwner.current
    DisposableEffect(
        key1 = lifecycleOwner,
        effect = {
            val observer = LifecycleEventObserver { _, event ->
                if(event == Lifecycle.Event.ON_CREATE) {
                    permissionsState.launchMultiplePermissionRequest()
                }
            }
            lifecycleOwner.lifecycle.addObserver(observer)

            onDispose {
                lifecycleOwner.lifecycle.removeObserver(observer)
            }
        }
    )

    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        permissionsState.permissions.forEach { perm ->
            when(perm.permission) {
                Manifest.permission.ACCESS_COARSE_LOCATION -> {
                    when {
                        perm.hasPermission -> {
                            WeatherScreen(
                                navController = navController
                            )
                        }
                        perm.shouldShowRationale -> {
                            Text(
                                text = stringResource(id = R.string.permission_is_needed),
                                color = BackgroundNight
                            )
                        }
                        perm.isPermanentlyDenied() -> {
                            Text(
                                text = stringResource(id = R.string.permission_is_needed),
                                color = BackgroundNight
                            )
                        }
                    }
                }
            }
        }
    }
}
