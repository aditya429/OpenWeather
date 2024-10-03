package org.aditya.weather.data.network.weatherRepository

import org.aditya.weather.data.model.WeatherDto
import org.aditya.weather.domain.model.CurrentLocation

interface WeatherRepository {
    suspend fun getWeatherInfo(curLoc: CurrentLocation): WeatherDto
}