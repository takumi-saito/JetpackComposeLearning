package com.example.githubclientapp.model.remote_data_source

import javax.inject.Inject

class RemoteDataSourceImpl @Inject constructor(
    private val apiClient: ApiClient
) : RemoteDataSource {
    override suspend fun getGitHubUser(userName: String): GithubUser {
        val response = apiClient.getGithubUser(userName = userName)
        if (response.isSuccessful) {
            val githubUser: GithubUser = requireNotNull(response.body())
            return githubUser
        }
        throw HttpException()
    }
}

class HttpException : Throwable()