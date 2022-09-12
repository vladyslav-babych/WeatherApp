package com.otaman.weather.di

import com.otaman.weather.domain.repository.WeatherRepository
import com.otaman.weather.networking.WeatherRepositoryImpl
import com.otaman.weather.networking.WeatherService
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object WeatherRepositoryModule {
    private const val BASE_URL = "https://api.weatherapi.com/v1/"

    @Singleton
    @Provides
    fun provideWeatherRepository(): WeatherRepository {
        val moshi = Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()

        val logging = HttpLoggingInterceptor()
        logging.setLevel(HttpLoggingInterceptor.Level.BODY)
        val client: OkHttpClient = OkHttpClient.Builder()
            .addInterceptor(logging)
            .build()

        val service = Retrofit.Builder()
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .baseUrl(BASE_URL)
            .client(client)
            .build()
            .create(WeatherService::class.java)

        return WeatherRepositoryImpl(service)
    }
}