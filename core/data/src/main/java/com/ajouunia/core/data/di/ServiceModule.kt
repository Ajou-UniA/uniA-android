package com.ajouunia.core.data.di

import com.ajouunia.core.data.service.OnBoardingService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
import retrofit2.Retrofit

@Module
@InstallIn(SingletonComponent::class)
object ServiceModule {

    @Singleton
    @Provides
    internal fun provideOnBoardingService(retrofit: Retrofit): OnBoardingService {
        return retrofit.create(OnBoardingService::class.java)
    }

}