package com.otaman.weather.ui.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.otaman.weather.domain.util.Resource
import com.otaman.weather.ui.WeatherState
import com.otaman.weather.domain.repository.WeatherRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainScreenViewModel @Inject constructor(
    private val repository: WeatherRepository
): ViewModel() {

    private val _state: MutableState<WeatherState> = mutableStateOf(WeatherState.Loading)
    val state: State<WeatherState> = _state

    init {
        getCurrentWeather("Lviv")
    }

    fun retry() {
        getCurrentWeather("Lviv")
    }

    private fun getCurrentWeather(query: String) = viewModelScope.launch {
        when(val result = repository.getCurrentWeather(query)) {
            is Resource.Success -> {
                _state.value = result.data.let { data ->
                    WeatherState.CurrentWeatherData(currentWeatherData = data)
                }
            }
            is Resource.Error -> {
                _state.value = result.message.let { message ->
                    WeatherState.Error(error = message)
                }
            }
        }
    }
}