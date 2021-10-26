package com.example.githubclientapp.di

import com.example.githubclientapp.model.repository.UserRepository
import com.example.githubclientapp.model.repository.UserRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
class UserRepositoryModule {

    @Provides
    fun providerUserRepository(
        userRepositoryImpl: UserRepositoryImpl
    ): UserRepository {
        return userRepositoryImpl
    }
}