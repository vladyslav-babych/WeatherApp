package com.otaman.weather.networking

import android.os.Build
import androidx.annotation.RequiresApi
import com.otaman.weather.BuildConfig
import com.otaman.weather.domain.repository.WeatherRepository
import com.otaman.weather.domain.util.Resource
import com.otaman.weather.domain.weather.CurrentWeather
import com.otaman.weather.domain.weather.ForecastWeather
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

    @RequiresApi(Build.VERSION_CODES.O)
    override suspend fun getForecast(
        query: String,
        daysAmount: Int
    ): Resource<List<ForecastWeather>> {
        return try {
            Resource.Success(
                data = weatherService.getForecast(
                    query = query,
                    key = key,
                    daysAmount = daysAmount,
                    aqi = "no",
                    alerts = "no"
                ).toForecast()
            )
        }
        catch (error: Exception) {
            error.printStackTrace()
            Resource.Error(error.message ?: "Error occurred")
        }
    }
}