package com.example.githubclientapp.di

import com.example.githubclientapp.model.remote_data_source.ApiClient
import com.example.githubclientapp.model.remote_data_source.ApiClientProvider
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.ExperimentalSerializationApi
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ApiClientModule {

    @ExperimentalSerializationApi
    @Provides
    @Singleton
    fun providerApiClient(
        apiClientProvider: ApiClientProvider
    ): ApiClient {
        return apiClientProvider.provide()
    }
}