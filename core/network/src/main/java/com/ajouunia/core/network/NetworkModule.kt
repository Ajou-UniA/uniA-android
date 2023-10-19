package com.ajouunia.core.network

import com.ajouunia.core.data.local.LocalUserDataSource
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object NetworkModule {
    private const val BASE_URL = "http://ec2-43-202-102-96.ap-northeast-2.compute.amazonaws.com:8080/api"
    private const val VERSION_FIRST = "/v1/"

    @Provides
    fun providerAuthInterceptor(localUserDataSource: LocalUserDataSource): AuthInterceptor = AuthInterceptor(localUserDataSource = localUserDataSource)

    @Provides
    fun provideLoggingInterceptor(): HttpLoggingInterceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    @Provides
    @Singleton
    fun providerHttpClient(
        loggingInterceptor: HttpLoggingInterceptor,
        authInterceptor: AuthInterceptor,
    ): OkHttpClient = OkHttpClient.Builder()
        .readTimeout(10, TimeUnit.SECONDS)
        .connectTimeout(10, TimeUnit.SECONDS)
        .writeTimeout(10, TimeUnit.SECONDS)
        .addInterceptor(loggingInterceptor)
        .addInterceptor(authInterceptor)
        .build()

    @Provides
    @Singleton
    fun provideRetrofit(
        okHttpClient: OkHttpClient,
        gsonConverterFactory: GsonConverterFactory,
        nullOrEmptyConverterFactory: NullOrEmptyConverterFactory,
        scalarsConverterFactory: ScalarsConverterFactory
    ): Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL + VERSION_FIRST)
        .client(okHttpClient)
        .addConverterFactory(nullOrEmptyConverterFactory)
        .addConverterFactory(scalarsConverterFactory)
        .addConverterFactory(gsonConverterFactory)
        .build()

    @Provides
    fun provideGsonConverterFactory(): GsonConverterFactory = GsonConverterFactory.create()

    @Provides
    fun provideScalarConverterFactory(): ScalarsConverterFactory = ScalarsConverterFactory.create()

    @Provides
    fun provideNullOrEmptyConverterFactory(): NullOrEmptyConverterFactory = NullOrEmptyConverterFactory()

}