package org.aditya.weather.data.network.weatherRepository


import org.aditya.weather.BuildConfig
import org.aditya.weather.data.model.WeatherDto
import org.aditya.weather.data.network.WeatherApi
import org.aditya.weather.domain.model.CurrentLocation
import javax.inject.Inject

class RemoteWeatherSource @Inject constructor(
    private val weatherApi: WeatherApi
) : WeatherRepository {
    override suspend fun getWeatherInfo(curLoc: CurrentLocation): WeatherDto =
        weatherApi.getWeatherInfo(
            curLoc.lat, curLoc.lon, BuildConfig.API_KEY
        )
}