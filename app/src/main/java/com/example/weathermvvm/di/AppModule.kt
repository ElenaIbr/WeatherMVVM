package com.example.weathermvvm.di

import com.example.weathermvvm.data.remote.OpenWeatherMapApi
import com.example.weathermvvm.data.repository.WeatherRepositoryImpl
import com.example.weathermvvm.domain.repository.WeatherRepository
import com.example.weathermvvm.utilits.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideOpenWeatherMapApi(): OpenWeatherMapApi {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(OpenWeatherMapApi::class.java)
    }

    @Provides
    @Singleton
    fun provideWeatherRepository(api: OpenWeatherMapApi): WeatherRepository {
        return WeatherRepositoryImpl(api)
    }

}