package com.otaman.weather.networking

import com.otaman.weather.networking.responses.CurrentWeatherResponse


interface WeatherRepository {
    suspend fun getCurrentWeather(query: String): CurrentWeatherResponse
}