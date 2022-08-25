package com.otaman.weather.ui

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.otaman.weather.ui.forecast_report_screen.ForecastReportScreen
import com.otaman.weather.ui.main_screen.MainScreen

@Composable
fun SetupNavGraph(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = Screen.Main.route
    ) {
        composable(
            route = Screen.Main.route
        ) {
            MainScreen(
                navController = navController
            )
        }
        composable(
            route = Screen.ForecastReport.route
        ) {
            ForecastReportScreen(
                navController = navController
            )
        }
    }
}