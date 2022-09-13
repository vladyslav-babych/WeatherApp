package com.otaman.weather.domain.repository

import com.otaman.weather.domain.util.Resource
import com.otaman.weather.domain.weather.CurrentWeather

interface WeatherRepository {
    suspend fun getCurrentWeather(query: String): Resource<CurrentWeather>
}