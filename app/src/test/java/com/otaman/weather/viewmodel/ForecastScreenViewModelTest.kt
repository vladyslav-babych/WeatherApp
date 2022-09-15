package com.otaman.weather.viewmodel

import com.otaman.weather.MainCoroutineRule
import com.otaman.weather.domain.repository.WeatherRepository
import com.otaman.weather.domain.util.Resource
import com.otaman.weather.domain.weather.ForecastWeather
import com.otaman.weather.ui.states.ForecastState
import com.otaman.weather.ui.viewmodel.ForecastScreenViewModel
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.runTest
import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class ForecastScreenViewModelTest {
    @MockK
    private lateinit var repository: WeatherRepository
    @InjectMockKs
    private lateinit var viewModel: ForecastScreenViewModel

    @get:Rule
    var mainDispatcherRule = MainCoroutineRule()

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
    }

    @Test
    fun getForecast_getsForecast() = runTest {
        val forecast = listOf(mockk<ForecastWeather>())
        val success = Resource.Success(forecast)

        coEvery { repository.getForecast("Lviv", 3) } returns success
        advanceUntilIdle()
        val expectedState = ForecastState.ForecastData(forecast)

        assertThat(expectedState, equalTo(viewModel.state.value))
    }

    @Test
    fun getForecast_showsError() = runTest {
        val error = Resource.Error<List<ForecastWeather>>("test error")

        coEvery { repository.getForecast("Lviv", 3) } returns error
        advanceUntilIdle()
        val expectedState = ForecastState.Error("test error")

        assertThat(expectedState, equalTo(viewModel.state.value))
    }

    @Test
    fun getForecast_isLoading() = runTest {
        val forecast = listOf(mockk<ForecastWeather>())
        val success = Resource.Success(forecast)

        coEvery { repository.getForecast("Lviv", 3) } returns success
        val expectedState = ForecastState.Loading

        assertThat(expectedState, equalTo(viewModel.state.value))
    }
}