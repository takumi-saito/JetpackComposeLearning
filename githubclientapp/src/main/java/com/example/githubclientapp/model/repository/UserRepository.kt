package com.example.githubclientapp.model.repository

import com.example.githubclientapp.model.User

interface UserRepository {
    suspend fun getUser(userName: String): User
}