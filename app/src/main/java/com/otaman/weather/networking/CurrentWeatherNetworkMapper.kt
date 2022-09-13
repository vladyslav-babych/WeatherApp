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

@RequiresApi(Build.VERSION_CODES.O)
fun ForecastResponse.toForecast(): List<ForecastWeather> {
    return forecast.forecastDay.map { item ->
        val localDate = LocalDate.parse(item.date)
        val month = localDate.month.toString()
        val day = localDate.dayOfMonth.toString()

        ForecastWeather(
            dayTemp = item.day.dayTemp,
            date = "$day $month",
            dayConditionIcon = "https:${item.day.dayCondition.dayConditionIcon}",
            hourly = item.hour.map { hour ->
                hour.toHourly()
            }
        )
    }
}

fun Hour.toHourly(): HourlyWeather {
    return HourlyWeather(
        hourlyTemp = temp,
        hourlyConditionIcon = "https:${condition.conditionIcon}",
        time = time.drop(11)
    )
}