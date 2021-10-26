package com.example.githubclientapp.model.remote_data_source

import com.squareup.moshi.Json

data class GithubUser (
    @Json(name = "id") val id: Long,
    @Json(name = "name") val name: String,
    @Json(name = "avatar_url") val avatarUrl: String,
    @Json(name = "blog") val blog: String
)