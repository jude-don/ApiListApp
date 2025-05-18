package com.fetch.ApiListApp.di

import com.fetch.ApiListApp.common.Constants
import com.fetch.ApiListApp.data.remote.FetchApi
import com.fetch.ApiListApp.domain.repository.FetchRepository
import com.fetch.ApiListApp.domain.repository.FetchRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideFetchApi(): FetchApi{
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(FetchApi::class.java)
    }

    @Provides
    @Singleton
    fun provideFetchRepository(api: FetchApi):FetchRepository{
        return FetchRepositoryImpl(api)
    }
}