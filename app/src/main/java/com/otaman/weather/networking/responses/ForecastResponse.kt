package com.otaman.weather.networking.responses

import com.squareup.moshi.Json

data class ForecastResponse (
    @Json(name = "forecast") val forecast: Forecast
) {
    data class Forecast (
        @Json(name = "forecastday") val forecastDay: List<ForecastDay>
    ) {
        data class ForecastDay (
            @Json(name = "date") val date: String,
            @Json(name = "day") val day: Day,
            @Json(name = "hour") val hour: List<Hour>,
        ) {
            data class Hour (
                @Json(name = "temp_c") val temp: Double,
                @Json(name = "condition") val condition: HourCondition,
                @Json(name = "time") val time: String
            ) {
                data class HourCondition (
                    @Json(name = "icon") val conditionIcon: String
                )
            }
            data class Day (
                @Json(name = "avgtemp_c") val dayTemp: Double,
                @Json(name = "condition") val dayCondition: DayCondition
            ) {
                data class DayCondition (
                    @Json(name = "icon") val dayConditionIcon: String
                )
            }
        }
    }
}