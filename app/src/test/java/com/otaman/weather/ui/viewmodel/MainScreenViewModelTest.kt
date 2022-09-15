package com.otaman.weather.ui.viewmodel

import com.otaman.weather.domain.repository.WeatherRepository
import com.otaman.weather.domain.util.Resource
import com.otaman.weather.domain.weather.CurrentWeather
import com.otaman.weather.ui.states.WeatherState
import io.mockk.*
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.runTest
import org.junit.Rule
import org.junit.Test
import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Before

@ExperimentalCoroutinesApi
class MainScreenViewModelTest {
    @MockK private lateinit var repository: WeatherRepository
    @InjectMockKs private lateinit var viewModel: MainScreenViewModel

    @get:Rule
    var mainDispatcherRule = MainCoroutineRule()

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
    }

    @Test
    fun getCurrentWeather_getsCurrentWeather() = runTest {
        val current = mockk<CurrentWeather>()
        val success = Resource.Success(current)

        coEvery { repository.getCurrentWeather("Lviv") } returns success
        advanceUntilIdle()
        val expectedState = WeatherState.CurrentWeatherData(current)

        assertThat(expectedState, equalTo(viewModel.state.value))
    }

    @Test
    fun getCurrentWeather_showsError() = runTest {
        val error = Resource.Error<CurrentWeather>("test error")

        coEvery { repository.getCurrentWeather("Lviv") } returns error
        advanceUntilIdle()
        val expectedState = WeatherState.Error("test error")

        assertThat(expectedState, equalTo(viewModel.state.value))
    }

    @Test
    fun getCurrentWeather_isLoading() = runTest {
        val current = mockk<CurrentWeather>()
        val success = Resource.Success(current)

        coEvery { repository.getCurrentWeather("Lviv") } returns success
        val expectedState = WeatherState.Loading

        assertThat(expectedState, equalTo(viewModel.state.value))
    }
}