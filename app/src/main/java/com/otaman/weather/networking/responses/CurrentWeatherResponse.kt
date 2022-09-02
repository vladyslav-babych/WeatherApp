package com.otaman.weather.networking.responses

import com.otaman.weather.data.Current
import com.squareup.moshi.Json

data class CurrentWeatherResponse (
    @Json(name = "current") val current: Current,
)