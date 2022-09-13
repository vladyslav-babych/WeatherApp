package com.otaman.weather.ui.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.otaman.weather.domain.repository.WeatherRepository
import com.otaman.weather.domain.util.Resource
import com.otaman.weather.ui.states.ForecastState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ForecastScreenViewModel @Inject constructor(
    private val repository: WeatherRepository
): ViewModel() {

    private val _state: MutableState<ForecastState> = mutableStateOf(ForecastState.Loading)
    val state: State<ForecastState> = _state

    init {
        getForecast("Lviv", 7)
    }

    fun retry() {
        getForecast("Lviv", 7)
    }

    private fun getForecast(query: String, daysAmount: Int) = viewModelScope.launch {
        when(val result = repository.getForecast(query, daysAmount)) {
            is Resource.Success -> {
                _state.value = result.data.let { data ->
                    ForecastState.ForecastData(forecastData = data)
                }
            }
            is Resource.Error -> {
                _state.value = result.message.let { message ->
                    ForecastState.Error(error = message)
                }
            }
        }
    }
}