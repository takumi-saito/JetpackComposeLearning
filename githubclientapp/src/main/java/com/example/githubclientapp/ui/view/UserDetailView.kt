package com.example.githubclientapp.ui.view

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import com.example.githubclientapp.model.User

@Composable
fun UserDetailView(user: User) {
    Text(
        text = user.userId.value.toString()
    )
    Text(
        text = user.name
    )
    Text(
        text = user.avatarImage.url.value
    )
    Text(
        text = user.blogUrl.value
    )
}