package com.otaman.weather.ui.forecast_report_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.otaman.weather.domain.weather.HourlyWeather
import com.otaman.weather.R
import java.text.SimpleDateFormat
import java.util.*

@Composable
private fun TodayForecastDate() {
    val dateInstance = Calendar.getInstance().time
    val formatter = SimpleDateFormat("MMM, dd")
    val date = formatter.format(dateInstance)

    Row(
        verticalAlignment = Alignment.Bottom,
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 24.dp)
    ) {
        Text(
            text = stringResource(id = R.string.today),
            style = MaterialTheme.typography.h3
        )

        Spacer(
            Modifier
                .weight(1f)
                .fillMaxWidth())

        Text(
            text = date,
            style = MaterialTheme.typography.h1,
            fontSize = 16.sp
        )
    }
}

@Composable
private fun TodayForecastListItem(
    todayForecastData: HourlyWeather
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(vertical = 12.dp)
            .background(color = Color.Transparent)
    ) {
        Text(
            text = stringResource(id = R.string.hourly_temp, todayForecastData.hourlyTemp),
            style = MaterialTheme.typography.h1,
            fontSize = 16.sp
        )
        Image(
            painter = rememberAsyncImagePainter(model = todayForecastData.hourlyConditionIcon),
            contentDescription = null,
            modifier = Modifier.size(56.dp)
        )
        Text(
            text = todayForecastData.time,
            style = MaterialTheme.typography.h1,
            fontSize = 16.sp
        )
    }
}

@Composable
private fun TodayForecastRow(
    todayForecast: List<HourlyWeather>
) {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(todayForecast) { todayForecastData ->
            TodayForecastListItem(
                todayForecastData = todayForecastData
            )
        }
    }
}

@Composable
fun TodayForecast(
    todayForecast: List<HourlyWeather>
) {
    Column(
        modifier = Modifier.padding(24.dp)
    ) {
        TodayForecastDate()
        TodayForecastRow(todayForecast)
    }
}