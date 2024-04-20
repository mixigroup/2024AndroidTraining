package jp.co.mixi.androidtraining.weather.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import jp.co.mixi.androidtraining.weather.data.repository.DefaultWeatherRepository
import jp.co.mixi.androidtraining.weather.data.repository.WeatherRepository
import kotlinx.coroutines.launch

class WeatherViewModel(
    private val repository: WeatherRepository = DefaultWeatherRepository(),
) : ViewModel() {

    var uiState by mutableStateOf(WeatherUiState())

    fun getWeather() {
        viewModelScope.launch {
            uiState = uiState.copy(isLoading = true)
            val weather = repository.getWeather()
            uiState = uiState.copy(weather = weather, isLoading = false)
        }
    }
}
