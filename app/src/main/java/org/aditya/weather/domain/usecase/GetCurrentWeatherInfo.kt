package org.aditya.weather.domain.usecase

import kotlinx.coroutines.flow.flow
import org.aditya.weather.data.Resource
import org.aditya.weather.data.network.weatherRepository.WeatherRepository
import org.aditya.weather.domain.model.CurrentLocation
import org.aditya.weather.domain.safeApiCall
import org.aditya.weather.domain.toWeatherInfo
import javax.inject.Inject

class GetCurrentWeatherInfo @Inject constructor() {
    suspend operator fun invoke(
        weatherSource: WeatherRepository,
        location: CurrentLocation
    ) = flow {
        emit(Resource.Loading("Loading weather information"))

        /**
         * Using safeApiCall to ensure the network call is dispatched to IO thread
         * and to handle any exception.
         **/
        emit(safeApiCall {
            weatherSource
                .getWeatherInfo(location)
                .toWeatherInfo()
        })
    }
}