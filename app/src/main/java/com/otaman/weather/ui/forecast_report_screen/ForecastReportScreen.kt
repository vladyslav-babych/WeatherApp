package com.otaman.weather.ui.forecast_report_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.otaman.weather.R
import com.otaman.weather.ui.Screen
import com.otaman.weather.ui.theme.BlueDark
import com.otaman.weather.ui.theme.BlueLight
import com.otaman.weather.ui.theme.WeatherTheme

@Composable
private fun AppBar(
    navController: NavController
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 24.dp)
            .background(color = Color.Transparent)
    ) {
        Button(
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.Transparent),
            elevation = null,
            onClick = {
                navController.navigate(route = Screen.Main.route) {
                    popUpTo(Screen.Main.route) {
                        inclusive = true
                    }
                }
            }
        ) {
            Icon(
                imageVector = Icons.Filled.KeyboardArrowLeft,
                contentDescription = "",
                modifier = Modifier
                    .size(32.dp),
                colorResource(id = R.color.white)
            )
            Text(
                text = "Back",
                style = MaterialTheme.typography.h1,
                fontSize = 24.sp
            )
        }
    }
}

@Composable
fun ForecastReportScreen(
    navController: NavController
) {
    WeatherTheme {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    brush = Brush.verticalGradient(
                        listOf(
                            BlueLight,
                            BlueDark
                        )
                    )
                ),
        ) {
            Scaffold(
                topBar = { AppBar(
                    navController = navController
                ) },
                backgroundColor = Color.Transparent
            ) {
                Column {
                    TodayForecast()
                    NextForecast()
                }
            }
        }
    }
}

@Preview
@Composable
private fun TopBarPreview() {
    WeatherTheme {
        AppBar(
            rememberNavController()
        )
    }
}

@Preview
@Composable
private fun ForecastReportScreenPreview() {
    ForecastReportScreen(
        rememberNavController()
    )
}