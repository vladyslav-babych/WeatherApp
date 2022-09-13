package com.otaman.weather.ui.forecast_report_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberAsyncImagePainter
import com.otaman.weather.R
import com.otaman.weather.domain.weather.ForecastWeather
import com.otaman.weather.ui.theme.WeatherTheme
import com.otaman.weather.ui.viewmodel.ForecastScreenViewModel

@Composable
private fun NextForecastTitle() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 24.dp)
    ) {
        Text(
            text = stringResource(id = R.string.next_forecast),
            style = MaterialTheme.typography.h3
        )
    }
}

@Composable
private fun NextForecastListItem(forecastData: ForecastWeather) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = forecastData.date,
            style = MaterialTheme.typography.h3,
            fontSize = 16.sp,
            textAlign = TextAlign.Start
        )

        Image(
            painter = rememberAsyncImagePainter(model = forecastData.dayConditionIcon),
            contentDescription = null,
            modifier = Modifier.size(56.dp)
        )

        Text(
            text = stringResource(id = R.string.daily_temp, forecastData.dayTemp),
            style = MaterialTheme.typography.h1,
            fontSize = 16.sp
        )
    }
}

@Composable
private fun NextForecastColumn(
    forecast: List<ForecastWeather>
) {
    LazyColumn(
        contentPadding = PaddingValues(bottom = 24.dp)
    ) {
        items(forecast) { forecastData ->
            NextForecastListItem(forecastData)
        }
    }
}

@Composable
fun NextForecast(
    forecast: List<ForecastWeather>
) {
    Column(
        modifier = Modifier.padding(24.dp)
    ) {
        NextForecastTitle()
        NextForecastColumn(forecast)
    }
}