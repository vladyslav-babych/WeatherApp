package com.otaman.weather.ui.states

import com.otaman.weather.domain.weather.CurrentWeather

sealed class WeatherState {
    data class CurrentWeatherData(val currentWeatherData: CurrentWeather): WeatherState()
    data class Error(val error: String): WeatherState()
    object Loading: WeatherState()
}
