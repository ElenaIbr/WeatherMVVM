package com.example.weathermvvm.presentation.weather_screen.components

import android.Manifest
import android.annotation.SuppressLint
import android.content.Context
import android.location.Location
import android.os.Looper
import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.navigation.NavController
import com.example.weathermvvm.R
import com.example.weathermvvm.presentation.ui.theme.BackgroundNight
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.rememberMultiplePermissionsState
import com.google.android.gms.location.*

@ExperimentalPermissionsApi
@Composable
fun RequestPermission(navController: NavController) {

    val permissionsState = rememberMultiplePermissionsState(
        permissions = listOf(
            Manifest.permission.ACCESS_COARSE_LOCATION,
            Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.CAMERA
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
                            requestNewLocationData(LocalContext.current)
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

@SuppressLint("MissingPermission")
private fun requestNewLocationData(current: Context) {
    lateinit var mFusedLocationClient: FusedLocationProviderClient
    val mLocationRequest = LocationRequest()
    mLocationRequest.priority = LocationRequest.PRIORITY_HIGH_ACCURACY
    mLocationRequest.interval = 0
    mLocationRequest.fastestInterval = 0
    mLocationRequest.numUpdates = 1

    mFusedLocationClient = LocationServices.getFusedLocationProviderClient(current)
    Looper.myLooper()?.let {
        mFusedLocationClient.requestLocationUpdates(
            mLocationRequest, mLocationCallback,
            it
        )
    }
}

private val mLocationCallback = object : LocationCallback() {
    override fun onLocationResult(locationResult: LocationResult) {
        val mLastLocation: Location = locationResult.lastLocation
        Log.d("cdvdsvd", mLastLocation.latitude.toString())
        Log.d("cdvdsvd", mLastLocation.longitude.toString())
    }
}