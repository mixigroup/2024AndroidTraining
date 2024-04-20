package jp.co.mixi.androidtraining.weather.ui

import jp.co.mixi.androidtraining.weather.data.repository.FakeWeatherRepository
import jp.co.mixi.androidtraining.weather.utils.MainDispatcherRule
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test

class WeatherViewModelTest {

    @get:Rule
    val dispatcherRule = MainDispatcherRule()

    private val viewModel = WeatherViewModel(FakeWeatherRepository())

    @Test
    fun testGetWeather() = runTest {
        assertEquals("", viewModel.uiState.weather)
        viewModel.getWeather()
        advanceUntilIdle()
        assertEquals("晴れ", viewModel.uiState.weather)
    }
}
