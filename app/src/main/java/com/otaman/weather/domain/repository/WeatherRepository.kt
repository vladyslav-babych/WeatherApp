package com.otaman.weather.domain.repository

import com.otaman.weather.domain.util.Resource
import com.otaman.weather.domain.weather.CurrentWeather
import com.otaman.weather.domain.weather.ForecastWeather

interface WeatherRepository {
    suspend fun getCurrentWeather(query: String): Resource<CurrentWeather>
    suspend fun getForecast(query: String, daysAmount: Int): Resource<List<ForecastWeather>>
}