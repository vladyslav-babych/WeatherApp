package com.otaman.weather.domain.weather

data class ForecastWeather (
    val dayTemp: Double,
    val dayConditionIcon: String,
    val date: String,
    val hourly: List<HourlyWeather>
)

data class HourlyWeather(
    val hourlyTemp: Double,
    val hourlyConditionIcon: String,
    val time: String
)