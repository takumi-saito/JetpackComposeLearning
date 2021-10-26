package com.example.githubclientapp.model.repository

import com.example.githubclientapp.model.NetworkImage
import com.example.githubclientapp.model.Url
import com.example.githubclientapp.model.User
import com.example.githubclientapp.model.UserId
import com.example.githubclientapp.model.remote_data_source.*
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource
) : UserRepository {
    override suspend fun getUser(userName: String): User {
        return remoteDataSource.getGitHubUser(userName).toUser()
    }
}

private fun GithubUser.toUser(): User {
    return User(
        userId = UserId(
            value = id
        ),
        name = name,
        avatarImage = NetworkImage(
            url = Url(
                value = avatarUrl
            )
        ),
        blogUrl = Url(
            value = blog
        )
    )
}