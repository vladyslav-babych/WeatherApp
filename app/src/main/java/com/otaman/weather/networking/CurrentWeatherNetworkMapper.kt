package com.otaman.weather.networking

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.ui.text.toLowerCase
import com.otaman.weather.domain.weather.CurrentWeather
import com.otaman.weather.domain.weather.ForecastWeather
import com.otaman.weather.domain.weather.HourlyWeather
import com.otaman.weather.networking.responses.CurrentWeatherResponse
import com.otaman.weather.networking.responses.ForecastResponse
import com.otaman.weather.networking.responses.ForecastResponse.Forecast.ForecastDay.Hour
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.OffsetDateTime
import java.time.format.DateTimeFormatter
import java.util.*

fun CurrentWeatherResponse.toCurrentWeather(): CurrentWeather {
    return CurrentWeather(
        temp = current.temp,
        wind = current.wind,
        humidity = current.humidity,
        conditionIcon = "https:${current.condition.iconCondition}",
        conditionText = current.condition.textCondition
    )
}

fun ForecastResponse.toForecast(): List<ForecastWeather> {
    return forecast.forecastDay.map { item ->
        val apiFormat = SimpleDateFormat("yyyy-MM-dd")
        val date = apiFormat.parse(item.date)
        val forecastFormat = SimpleDateFormat("dd MMM")
        val formattedDate = forecastFormat.format(date)

        ForecastWeather(
            dayTemp = item.day.dayTemp,
            date = formattedDate,
            dayConditionIcon = "https:${item.day.dayCondition.dayConditionIcon}",
            hourly = item.hour.map { hour ->
                hour.toHourly()
            }
        )
    }
}

fun Hour.toHourly(): HourlyWeather {
    val apiFormat = SimpleDateFormat("yyyy-MM-dd HH:mm")
    val time = apiFormat.parse(time)
    val forecastFormat = SimpleDateFormat("HH:mm")
    val formattedTime = forecastFormat.format(time)

    return HourlyWeather(
        hourlyTemp = temp,
        hourlyConditionIcon = "https:${condition.conditionIcon}",
        time = formattedTime
    )
}