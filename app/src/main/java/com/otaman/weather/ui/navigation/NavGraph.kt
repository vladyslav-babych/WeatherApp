package com.otaman.weather.ui.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.otaman.weather.ui.forecast_report_screen.ForecastReportScreen
import com.otaman.weather.ui.main_screen.MainScreen
import com.otaman.weather.ui.viewmodel.ForecastScreenViewModel
import com.otaman.weather.ui.viewmodel.MainScreenViewModel

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
            val mainScreenViewModel = hiltViewModel<MainScreenViewModel>()
            MainScreen(
                onForecastReportButtonClick = {
                    navController.navigate(Screen.ForecastReport.route)
                },
                viewModel = mainScreenViewModel
            )
        }
        composable(
            route = Screen.ForecastReport.route
        ) {
            val forecastScreenViewModel = hiltViewModel<ForecastScreenViewModel>()
            ForecastReportScreen(
                onBackClick = {
                    navController.popBackStack()
                },
                viewModel = forecastScreenViewModel
            )
        }
    }
}