package com.example.githubclientapp.model

data class User (
    val userId: UserId,
    val name: String,
    val avatarImage: NetworkImage,
    val blogUrl: Url
        )

data class NetworkImage(
    val url: Url
)

data class Url(
    val value: String
)

data class UserId(
    val value: Long)