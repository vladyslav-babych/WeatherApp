package com.otaman.weather.networking

import com.otaman.weather.BuildConfig
import com.otaman.weather.domain.repository.WeatherRepository
import com.otaman.weather.domain.util.Resource
import com.otaman.weather.domain.weather.CurrentWeather
import kotlin.Exception

class WeatherRepositoryImpl(private val weatherService: WeatherService): WeatherRepository {
    private val key = BuildConfig.API_KEY

    override suspend fun getCurrentWeather(
        query: String
    ): Resource<CurrentWeather> {
        return try {
            Resource.Success(
                data = weatherService.getCurrent(
                    query = query,
                    key = key,
                    aqi = "no"
                ).toCurrentWeather()
            )
        }
        catch (error: Exception) {
            error.printStackTrace()
            Resource.Error(error.message ?: "Error occurred")
        }
    }
}