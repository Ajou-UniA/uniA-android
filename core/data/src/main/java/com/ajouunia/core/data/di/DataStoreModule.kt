package com.ajouunia.core.data.di

import android.content.Context
import com.ajouunia.core.data.local.DataStoreDataSource
import com.ajouunia.core.data.local.impl.DataStoreDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataStoreModule {

    @Singleton
    @Provides
    fun provideDataStoreDataSource(
        @ApplicationContext context: Context
    ): DataStoreDataSource = DataStoreDataSourceImpl(context = context)

}