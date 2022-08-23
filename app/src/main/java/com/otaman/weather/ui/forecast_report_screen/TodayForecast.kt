package com.otaman.weather.ui.forecast_report_screen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.otaman.weather.R
import com.otaman.weather.ui.theme.WeatherTheme

@Composable
fun TodayForecastDate() {
    Row(
        verticalAlignment = Alignment.Bottom,
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 24.dp)
    ) {
        Text(
            text = "Today",
            style = MaterialTheme.typography.h3
        )

        Spacer(
            Modifier
                .weight(1f)
                .fillMaxWidth())

        Text(
            text = "Sep, 12",
            style = MaterialTheme.typography.h1,
            fontSize = 16.sp
        )
    }
}

@Composable
fun TodayForecastListItem() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(vertical = 12.dp)
            .background(color = Color.Transparent)
    ) {
        Text(
            text = "24°C",
            style = MaterialTheme.typography.h1,
            fontSize = 16.sp
        )
        Box(
            modifier = Modifier
                .size(60.dp)
                .padding(top = 12.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.weather_cloudy),
                contentDescription = null
            )
        }
        Text(
            text = "17.00",
            style = MaterialTheme.typography.h1,
            fontSize = 16.sp
        )
    }
}

@Composable
fun TodayForecastListItemCard() {
    Card(
        modifier = Modifier
            .padding(horizontal = 12.dp),
        backgroundColor = Color.White.copy(alpha = 0.4f),
        border = BorderStroke(1.dp, Color.White.copy(alpha = 0.6f)),
        shape = RoundedCornerShape(24.dp),
        elevation = 0.dp
    ) {
        TodayForecastListItem()
    }
}

@Composable
fun TodayForecastRow() {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(todayForecastList) {
            TodayForecastListItem()
        }
    }
}

@Composable
fun TodayForecast() {
    Column(
        modifier = Modifier.padding(24.dp)
    ) {
        TodayForecastDate()
        TodayForecastRow()
    }
}

private val todayForecastList = listOf(
    "24°C" to R.drawable.weather_cloudy to "00.00",
    "24°C" to R.drawable.weather_cloudy to "01.00",
    "24°C" to R.drawable.weather_cloudy to "02.00",
    "24°C" to R.drawable.weather_cloudy to "03.00",
    "24°C" to R.drawable.weather_cloudy to "04.00",
    "24°C" to R.drawable.weather_cloudy to "05.00",
    "24°C" to R.drawable.weather_cloudy to "06.00",
    "24°C" to R.drawable.weather_cloudy to "07.00",
    "24°C" to R.drawable.weather_cloudy to "08.00",
    "24°C" to R.drawable.weather_cloudy to "09.00",
    "24°C" to R.drawable.weather_cloudy to "10.00",
    "24°C" to R.drawable.weather_cloudy to "11.00",
    "24°C" to R.drawable.weather_cloudy to "12.00",
    "24°C" to R.drawable.weather_cloudy to "13.00",
    "24°C" to R.drawable.weather_cloudy to "14.00",
    "24°C" to R.drawable.weather_cloudy to "15.00",
    "24°C" to R.drawable.weather_cloudy to "16.00",
    "24°C" to R.drawable.weather_cloudy to "17.00",
    "24°C" to R.drawable.weather_cloudy to "18.00",
    "24°C" to R.drawable.weather_cloudy to "19.00",
    "24°C" to R.drawable.weather_cloudy to "20.00",
    "24°C" to R.drawable.weather_cloudy to "21.00",
    "24°C" to R.drawable.weather_cloudy to "22.00",
    "24°C" to R.drawable.weather_cloudy to "23.00"
)

@Preview
@Composable
fun TodayForecastDatePreview() {
    WeatherTheme {
        TodayForecastDate()
    }
}

@Preview
@Composable
fun TodayForecastListItemPreview() {
    WeatherTheme {
        TodayForecastListItem()
    }
}

@Preview
@Composable
fun TodayForecastListItemCardPreview() {
    WeatherTheme {
        TodayForecastListItemCard()
    }
}

@Preview
@Composable
fun TodayForecastRowPreview() {
    WeatherTheme {
        TodayForecastRow()
    }
}

@Preview
@Composable
fun TodayForecastPreview() {
    WeatherTheme {
        TodayForecast()
    }
}