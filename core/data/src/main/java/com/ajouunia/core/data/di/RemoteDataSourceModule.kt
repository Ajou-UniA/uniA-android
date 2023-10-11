package com.ajouunia.core.data.di

import com.ajouunia.core.data.remote.OnBoardingDataSource
import com.ajouunia.core.data.remote.OnBoardingDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal abstract class RemoteDataSourceModule {

    @Binds
    @Singleton
    abstract fun bindOnBoardingDataSource(
        onBoardingDataSourceImpl: OnBoardingDataSourceImpl,
    ): OnBoardingDataSource

}