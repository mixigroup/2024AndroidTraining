package jp.co.mixi.androidtraining.weather.ui

data class WeatherUiState(
    val weather: String = "",
    val isLoading: Boolean = false,
)
