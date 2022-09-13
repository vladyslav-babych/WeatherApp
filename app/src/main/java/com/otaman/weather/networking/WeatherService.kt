package com.otaman.weather.networking

import com.otaman.weather.networking.responses.CurrentWeatherResponse
import com.otaman.weather.networking.responses.ForecastResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherService {
    @GET("current.json")
    suspend fun getCurrent(
        @Query("q") query: String,
        @Query("key") key: String,
        @Query("aqi") aqi: String
    ): CurrentWeatherResponse

    @GET("forecast.json")
    suspend fun getForecast(
        @Query("q") query: String,
        @Query("key") key: String,
        @Query("days") daysAmount: Int,
        @Query("aqi") aqi: String,
        @Query("alerts") alerts: String
    ): ForecastResponse
}