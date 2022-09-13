package com.otaman.weather.ui.main_screen

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberAsyncImagePainter
import com.otaman.weather.R
import com.otaman.weather.domain.weather.CurrentWeather
import com.otaman.weather.ui.states.WeatherState
import com.otaman.weather.ui.theme.BlueDark
import com.otaman.weather.ui.theme.BlueLight
import com.otaman.weather.ui.viewmodel.MainScreenViewModel
import java.text.SimpleDateFormat
import java.util.*

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
                text = stringResource(id = R.string.city),
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
                text = stringResource(id = R.string.forecast_report),
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
private fun WeatherConditionIcon(
    icon: String
) {
    Image(
        painter = rememberAsyncImagePainter(icon),
        contentDescription = null,
        modifier = Modifier.size(200.dp)
    )
}

@Composable
private fun WeatherDetail(
    weatherState: CurrentWeather
) {
    val dateInstance = Calendar.getInstance().time
    val formatter = SimpleDateFormat("dd MMM")
    val date = formatter.format(dateInstance)

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
                text = stringResource(id = R.string.date_today_card, date),
                style = MaterialTheme.typography.h1,
                fontSize = 20.sp
            )
            Text(
                text = stringResource(id = R.string.current_temp, weatherState.temp),
                fontSize = 96.sp,
                style = MaterialTheme.typography.h2
            )
            Text(
                text = weatherState.conditionText,
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
                    text = stringResource(id = R.string.wind),
                    style = MaterialTheme.typography.h1,
                    textAlign = TextAlign.End,
                    fontSize = 18.sp,
                    modifier = Modifier.width(70.dp)
                )
                Text(
                    text = "|",
                    style = MaterialTheme.typography.h1,
                    textAlign = TextAlign.Center,
                    fontSize = 12.sp,
                    modifier = Modifier.width(40.dp)
                )
                Text(
                    text = stringResource(id = R.string.wind_speed, weatherState.wind),
                    style = MaterialTheme.typography.h1,
                    textAlign = TextAlign.Start,
                    fontSize = 18.sp,
                    modifier = Modifier.width(90.dp)
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
                    text = stringResource(id = R.string.hum),
                    style = MaterialTheme.typography.h1,
                    textAlign = TextAlign.End,
                    fontSize = 18.sp,
                    modifier = Modifier.width(70.dp)
                )
                Text(
                    text = "|",
                    style = MaterialTheme.typography.h1,
                    textAlign = TextAlign.Center,
                    fontSize = 12.sp,
                    modifier = Modifier.width(40.dp)
                )
                Text(
                    text = stringResource(id = R.string.humidity, weatherState.humidity, "%"),
                    style = MaterialTheme.typography.h1,
                    textAlign = TextAlign.Start,
                    fontSize = 18.sp,
                    modifier = Modifier.width(90.dp)
                )
            }
        }
    }
}

@Composable
fun MainScreen(
    onForecastReportButtonClick: () -> Unit,
    viewModel: MainScreenViewModel = viewModel()
) {
    val weatherState by remember {
        viewModel.state
    }
    when(val state = weatherState) {
        is WeatherState.CurrentWeatherData -> {
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
                    )
                ) {
                Scaffold(
                    topBar = { AppBar() },
                    backgroundColor = Color.Transparent,
                    bottomBar = { ForecastReportButton(
                        onForecastReportButtonClick = onForecastReportButtonClick
                    ) }
                ) {
                    Column(
                        modifier = Modifier
                            .verticalScroll(rememberScrollState()),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        WeatherConditionIcon(state.currentWeatherData.conditionIcon)
                        WeatherDetail(state.currentWeatherData)
                    }
                }
            }
        }
        is WeatherState.Loading -> {
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
        is WeatherState.Error -> {
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
                        color = Red,
                        textAlign = TextAlign.Center
                    )
                    Text(
                        text = stringResource(id = R.string.retry),
                        style = MaterialTheme.typography.h1,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.clickable { viewModel.retry() }
                    )
                }
            }
        }
    }
}