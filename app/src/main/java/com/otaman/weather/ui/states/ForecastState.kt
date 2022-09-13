package com.otaman.weather.ui.states

import com.otaman.weather.domain.weather.ForecastWeather

sealed class ForecastState {
    data class ForecastData(val forecastData: List<ForecastWeather>): ForecastState()
    data class Error(val error: String): ForecastState()
    object Loading: ForecastState()
}