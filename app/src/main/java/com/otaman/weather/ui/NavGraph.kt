package com.otaman.weather.ui

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraph.Companion.findStartDestination
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
            MainScreen(onForecastReportButtonClick = {
                navController.navigate(Screen.ForecastReport.route)
            })
        }
        composable(
            route = Screen.ForecastReport.route
        ) {
            ForecastReportScreen(onBackClick = {
                navController.popBackStack()
            })
        }
    }
}