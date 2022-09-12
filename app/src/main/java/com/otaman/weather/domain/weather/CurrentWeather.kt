package com.otaman.weather.domain.weather

data class CurrentWeather (
    val temp: Double,
    val wind: Double,
    val humidity: Int,
    val conditionIcon: String,
    val conditionText: String
)