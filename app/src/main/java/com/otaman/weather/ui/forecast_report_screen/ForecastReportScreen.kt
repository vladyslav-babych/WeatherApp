package com.otaman.weather.ui.forecast_report_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.otaman.weather.R
import com.otaman.weather.ui.states.ForecastState
import com.otaman.weather.ui.theme.BlueDark
import com.otaman.weather.ui.theme.BlueLight
import com.otaman.weather.ui.theme.WeatherTheme
import com.otaman.weather.ui.viewmodel.ForecastScreenViewModel

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
    onBackClick: () -> Unit,
    viewModel: ForecastScreenViewModel = viewModel()
) {
    val forecastState by remember {
        viewModel.state
    }
    when(val state = forecastState) {
        is ForecastState.ForecastData -> {
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
                            TodayForecast(state.forecastData.first().hourly)
                            NextForecast(state.forecastData)
                        }
                    }
                }
            }
        }
        is ForecastState.Loading -> {
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
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }
        }
        is ForecastState.Error -> {
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
                contentAlignment = Alignment.Center
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = state.error,
                        style = MaterialTheme.typography.h1,
                        color = Color.Red,
                        textAlign = TextAlign.Center
                    )
                    Text(
                        text = "Click here to retry",
                        style = MaterialTheme.typography.h1,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.clickable { viewModel.retry() }
                    )
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