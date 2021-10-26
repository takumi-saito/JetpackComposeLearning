package com.example.githubclientapp.di

import com.example.githubclientapp.model.remote_data_source.RemoteDataSource
import com.example.githubclientapp.model.remote_data_source.RemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import kotlinx.serialization.ExperimentalSerializationApi
import javax.inject.Singleton

@Module
@InstallIn(ViewModelComponent::class)
class RemoteDataSourceModule {

    @Provides
    fun providerRemoteDataSource(
        remoteDataSourceImpl: RemoteDataSourceImpl
    ): RemoteDataSource {
        return remoteDataSourceImpl
    }
}