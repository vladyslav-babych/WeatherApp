package com.otaman.weather.networking

import com.otaman.weather.networking.responses.CurrentWeatherResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherService {
    @GET("current.json")
    suspend fun getCurrent(
        @Query("q") query: String,
        @Query("key") key: String,
        @Query("aqi") aqi: String
    ): CurrentWeatherResponse
}