package com.otaman.weather.ui.main_screen

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.otaman.weather.R
import com.otaman.weather.ui.theme.BlueDark
import com.otaman.weather.ui.theme.BlueLight
import com.otaman.weather.ui.theme.WeatherTheme

@Composable
private fun AppBar() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp, vertical = 24.dp)
            .background(color = Color.Transparent)
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_pin),
            contentDescription = null,
            modifier = Modifier
                .size(32.dp)
        )
        OutlinedButton(
            onClick = { /*TODO*/ },
            border = null,
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.Transparent)
        ) {
            Text(
                text = "Semarang",
                style = MaterialTheme.typography.body2,
                fontSize = 24.sp
            )
            Icon(
                imageVector = Icons.Filled.KeyboardArrowDown,
                contentDescription = "",
                modifier = Modifier
                    .size(36.dp)
                    .padding(start = 12.dp),
                colorResource(id = R.color.white)
            )
        }
        Spacer(
            Modifier
                .weight(1f)
                .fillMaxWidth()
        )
        Box {
            Image(
                painter = painterResource(id = R.drawable.ic_bell),
                contentDescription = null,
                modifier = Modifier
                    .size(26.dp)
                    .padding(end = 2.dp),
                alignment = Alignment.CenterEnd
            )
            Image(
                painter = painterResource(id = R.drawable.ic_bell_dot),
                contentDescription = null,
                modifier = Modifier.align(Alignment.TopEnd)
            )
        }
    }
}

@Composable
private fun ForecastReportButton(
    onForecastReportButtonClick: () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OutlinedButton(
            shape = RoundedCornerShape(16.dp),
            onClick = onForecastReportButtonClick,
            modifier = Modifier
                .width(200.dp)
                .height(90.dp)
                .padding(bottom = 36.dp)
        ) {
            Text(
                text = "Forecast report",
                style = MaterialTheme.typography.body1,
                color = Color.Black,
                fontSize = 18.sp
            )
            Icon(
                imageVector = Icons.Filled.KeyboardArrowRight,
                contentDescription = null,
                modifier = Modifier
                    .size(24.dp)
                    .padding(start = 6.dp),
                colorResource(id = R.color.black)
            )
        }
    }
}

@Composable
private fun WeatherType() {
    Image(
        painter = painterResource(id = R.drawable.weather_cloudy),
        contentDescription = null
    )
}

@Composable
private fun WeatherDetail() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp),
        backgroundColor = Color.White.copy(alpha = 0.4f),
        border = BorderStroke(2.dp, Color.White.copy(alpha = 0.6f)),
        shape = RoundedCornerShape(30.dp),
        elevation = 0.dp
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(vertical = 24.dp)
                .background(color = Color.Transparent)
        ) {
            Text(
                text = "Today, 12 September",
                style = MaterialTheme.typography.h1,
                fontSize = 20.sp
            )
            Text(
                text = " 29°",
                fontSize = 96.sp,
                style = MaterialTheme.typography.h2
            )
            Text(
                text = "Cloudy",
                style = MaterialTheme.typography.h3
            )
            Spacer(modifier = Modifier.padding(12.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_wind),
                    contentDescription = null
                )
                Text(
                    text = "Wind",
                    style = MaterialTheme.typography.h1,
                    textAlign = TextAlign.Center,
                    fontSize = 18.sp,
                    modifier = Modifier
                        .width(80.dp)
                )
                Text(
                    text = "|",
                    style = MaterialTheme.typography.h1,
                    textAlign = TextAlign.Center,
                    fontSize = 12.sp,
                    modifier = Modifier.width(40.dp)
                )
                Text(
                    text = "10 km/h",
                    style = MaterialTheme.typography.h1,
                    textAlign = TextAlign.Start,
                    fontSize = 18.sp,
                    modifier = Modifier
                        .width(90.dp)
                        .padding(start = 20.dp)
                )
            }
            Spacer(modifier = Modifier.padding(6.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_hum),
                    contentDescription = null
                )
                Text(
                    text = "Hum",
                    style = MaterialTheme.typography.h1,
                    textAlign = TextAlign.Center,
                    fontSize = 18.sp,
                    modifier = Modifier.width(80.dp)
                )
                Text(
                    text = "|",
                    style = MaterialTheme.typography.h1,
                    textAlign = TextAlign.Center,
                    fontSize = 12.sp,
                    modifier = Modifier.width(40.dp)
                )
                Text(
                    text = "54 %",
                    style = MaterialTheme.typography.h1,
                    textAlign = TextAlign.Start,
                    fontSize = 18.sp,
                    modifier = Modifier
                        .width(90.dp)
                        .padding(start = 20.dp)
                )
            }
        }
    }
}

@Composable
private fun WeatherContent() {
    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        WeatherType()
        WeatherDetail()
    }
}

@Composable
fun MainScreen(
    onForecastReportButtonClick: () -> Unit
) {
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
            topBar = { AppBar() },
            backgroundColor = Color.Transparent,
            bottomBar = { ForecastReportButton(
                onForecastReportButtonClick = onForecastReportButtonClick
            ) }
        ) {
            WeatherContent()
        }
    }

}

@Preview
@Composable
private fun AppBarPreview() {
    WeatherTheme {
        AppBar()
    }
}

@Preview
@Composable
private fun WeatherTypePreview() {
    WeatherType()
}

@Preview
@Composable
private fun WeatherDetailPreview() {
    WeatherTheme {
        WeatherDetail()
    }
}

@Preview
@Composable
private fun ButtonPreview() {
    WeatherTheme {
        ForecastReportButton(onForecastReportButtonClick = {})
    }
}

@Preview
@Composable
private fun WeatherContentPreview() {
    WeatherTheme {
        WeatherContent()
    }
}

@Preview(showBackground = true)
@Composable
private fun MainScreenPreview() {
    WeatherTheme {
        MainScreen(onForecastReportButtonClick = {})
    }
}