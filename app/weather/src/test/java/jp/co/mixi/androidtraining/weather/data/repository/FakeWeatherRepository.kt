package jp.co.mixi.androidtraining.weather.data.repository

import kotlinx.coroutines.delay

class FakeWeatherRepository : WeatherRepository {
    override suspend fun getWeather(): String {
        delay(2000)
        return "晴れ"
    }
}
