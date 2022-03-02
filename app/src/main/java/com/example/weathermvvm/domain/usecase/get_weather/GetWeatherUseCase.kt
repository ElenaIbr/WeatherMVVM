package com.example.weathermvvm.domain.usecase.get_weather

import com.example.weathermvvm.data.remote.dto.PeriodDto
import com.example.weathermvvm.data.remote.dto.toPeriod
import com.example.weathermvvm.domain.model.Period
import com.example.weathermvvm.domain.repository.WeatherRepository
import com.example.weathermvvm.utilits.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetWeatherUseCase @Inject constructor(
    private val repository: WeatherRepository
) {
    operator fun invoke(lat: String, lon: String): Flow<Resource<Period>> = flow {
        try {
            emit(Resource.Loading())
            val weather = repository.getWeather(lat, lon).toPeriod()
            emit(Resource.Success(weather))
        } catch(e: HttpException){
            emit(Resource.Error<Period>(e.localizedMessage ?: "An unexpected error"))
        } catch (e: IOException){
            emit(Resource.Error<Period>("Couldn't reach server"))
        }
    }
}