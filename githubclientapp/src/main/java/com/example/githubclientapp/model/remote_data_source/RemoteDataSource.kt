package com.example.githubclientapp.model.remote_data_source

interface RemoteDataSource {
    suspend fun getGitHubUser(userName: String): GithubUser
}