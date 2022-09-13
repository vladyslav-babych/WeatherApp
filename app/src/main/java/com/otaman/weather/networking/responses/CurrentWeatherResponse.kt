package com.otaman.weather.networking.responses

import com.squareup.moshi.Json

data class CurrentWeatherResponse (
    @Json(name = "current") val current: Current
) {
    data class Current(
        @Json(name = "temp_c") val temp: Double,
        @Json(name = "wind_kph") val wind: Double,
        @Json(name = "humidity") val humidity: Int,
        @Json(name = "condition") val condition: Condition
    ) {
        data class Condition(
            @Json(name = "icon") val iconCondition: String,
            @Json(name = "text") val textCondition: String
        )
    }
}