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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.otaman.weather.R
import com.otaman.weather.ui.theme.WeatherTheme

@Composable
fun NextForecastTitle() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 24.dp)
    ) {
        Text(
            text = "Next Forecast",
            style = MaterialTheme.typography.h3
        )
    }
}

@Composable
fun NextForecastListItem() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth(),
    ) {
        Text(
            text = "Sep, 13",
            style = MaterialTheme.typography.h3,
            fontSize = 16.sp,
            textAlign = TextAlign.Start
        )
        Spacer(modifier = Modifier.width(90.dp))
        Box(
            modifier = Modifier
                .size(64.dp),
            contentAlignment = Alignment.BottomCenter
        ) {
            Image(
                painter = painterResource(id = R.drawable.weather_cloudy),
                contentDescription = null,

            )
        }
        Spacer(modifier = Modifier.width(90.dp))
        Text(
            text = "21°C",
            style = MaterialTheme.typography.h1,
            fontSize = 16.sp
        )
    }
}

@Composable
fun NextForecastColumn() {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(bottom = 24.dp)
    ) {
        items(nextForecastList) {
            NextForecastListItem()
        }
    }
}

@Composable
fun NextForecast() {
    Column(
        modifier = Modifier.padding(24.dp)
    ) {
        NextForecastTitle()
        NextForecastColumn()
    }
}

private val nextForecastList = listOf(
    "Sep, 13" to R.drawable.weather_cloudy to "21°C",
    "Sep, 13" to R.drawable.weather_cloudy to "21°C",
    "Sep, 13" to R.drawable.weather_cloudy to "21°C",
    "Sep, 13" to R.drawable.weather_cloudy to "21°C",
    "Sep, 13" to R.drawable.weather_cloudy to "21°C",
    "Sep, 13" to R.drawable.weather_cloudy to "21°C",
    "Sep, 13" to R.drawable.weather_cloudy to "21°C",
    "Sep, 13" to R.drawable.weather_cloudy to "21°C",
    "Sep, 13" to R.drawable.weather_cloudy to "21°C",
    "Sep, 13" to R.drawable.weather_cloudy to "21°C",
    "Sep, 13" to R.drawable.weather_cloudy to "21°C",
    "Sep, 13" to R.drawable.weather_cloudy to "21°C",
    "Sep, 13" to R.drawable.weather_cloudy to "21°C",
    "Sep, 13" to R.drawable.weather_cloudy to "21°C"
)

@Preview
@Composable
fun NextForecastTitlePreview() {
    WeatherTheme {
        NextForecastTitle()
    }
}

@Preview
@Composable
fun NextForecastListItemPreview() {
    WeatherTheme {
        NextForecastListItem()
    }
}

@Preview
@Composable
fun NextForecastColumnPreview() {
    WeatherTheme {
        NextForecastColumn()
    }
}

@Preview
@Composable
fun NextForecastPreview() {
    WeatherTheme {
        NextForecast()
    }
}