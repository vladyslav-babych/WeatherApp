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
import com.otaman.weather.R
import com.otaman.weather.ui.theme.BlueDark
import com.otaman.weather.ui.theme.BlueLight
import com.otaman.weather.ui.theme.WeatherTheme

@Composable
private fun AppBar(
    onBackClick: () -> Unit
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
            onClick = onBackClick
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
    onBackClick: () -> Unit
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
                    onBackClick = onBackClick
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
        AppBar(onBackClick = {})
    }
}

@Preview
@Composable
private fun ForecastReportScreenPreview() {
    ForecastReportScreen(onBackClick = {})
}