package com.otaman.weather.ui.navigation

sealed class Screen(val route: String) {
    object Main: Screen(route = "main_screen")
    object ForecastReport: Screen(route = "forecast_report_screen")
}
