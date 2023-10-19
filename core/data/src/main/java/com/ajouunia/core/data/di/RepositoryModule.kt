package com.ajouunia.core.data.di

import com.ajouunia.core.data.repository.GuideRepositoryImpl
import com.ajouunia.core.data.repository.OnBoardingRepositoryImpl
import com.ajouunia.core.domain.repository.GuideRepository
import com.ajouunia.core.domain.repository.OnBoardingRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindOnBoardingRepository(
        onBoardingRepositoryImpl: OnBoardingRepositoryImpl
    ): OnBoardingRepository

    @Binds
    @Singleton
    abstract fun bindGuideRepository(
        guideRepositoryImpl: GuideRepositoryImpl
    ): GuideRepository

}