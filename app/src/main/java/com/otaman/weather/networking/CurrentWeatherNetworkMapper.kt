package com.otaman.weather.networking

import com.otaman.weather.domain.weather.CurrentWeather
import com.otaman.weather.networking.responses.CurrentWeatherResponse

fun CurrentWeatherResponse.toCurrentWeather(): CurrentWeather {
    return CurrentWeather(
        temp = current.temp,
        wind = current.wind,
        humidity = current.humidity,
        conditionIcon = "https:${current.condition.iconCondition}",
        conditionText = current.condition.textCondition
    )
}