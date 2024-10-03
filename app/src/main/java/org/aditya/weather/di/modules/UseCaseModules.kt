package org.aditya.weather.di.modules

import android.app.Application
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import org.aditya.weather.domain.usecase.GetFusedCurrentLocation

@Module
@InstallIn(ViewModelComponent::class)
class UseCaseModules {
    @Provides
    fun provideGetFusedCurrentLocationUseCase(application: Application): GetFusedCurrentLocation {
        return GetFusedCurrentLocation(application)
    }
}