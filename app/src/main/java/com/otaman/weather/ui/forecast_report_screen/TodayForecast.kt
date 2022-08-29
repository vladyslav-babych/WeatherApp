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
private fun TodayForecastDate() {
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
private fun TodayForecastListItem() {
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
        Image(
            painter = painterResource(id = R.drawable.weather_cloudy),
            contentDescription = null,
            modifier = Modifier.size(64.dp)
        )
        Text(
            text = "17.00",
            style = MaterialTheme.typography.h1,
            fontSize = 16.sp
        )
    }
}

@Composable
private fun TodayForecastListItemCard() {
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
private fun TodayForecastRow() {
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

private val todayForecastList = List(24) {}

@Preview
@Composable
private fun TodayForecastDatePreview() {
    WeatherTheme {
        TodayForecastDate()
    }
}

@Preview
@Composable
private fun TodayForecastListItemPreview() {
    WeatherTheme {
        TodayForecastListItem()
    }
}

@Preview
@Composable
private fun TodayForecastListItemCardPreview() {
    WeatherTheme {
        TodayForecastListItemCard()
    }
}

@Preview
@Composable
private fun TodayForecastRowPreview() {
    WeatherTheme {
        TodayForecastRow()
    }
}

@Preview
@Composable
private fun TodayForecastPreview() {
    WeatherTheme {
        TodayForecast()
    }
}