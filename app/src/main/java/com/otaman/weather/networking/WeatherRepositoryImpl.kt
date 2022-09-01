package com.otaman.weather.networking

import com.otaman.weather.BuildConfig
import com.otaman.weather.networking.responses.CurrentWeatherResponse

class WeatherRepositoryImpl(private val weatherService: WeatherService): WeatherRepository {
    override suspend fun getCurrentWeather(query: String): CurrentWeatherResponse {
        val key = BuildConfig.API_KEY
        return weatherService.getCurrent(
            query = query,
            key = key,
            aqi = "no"
        )
    }
}