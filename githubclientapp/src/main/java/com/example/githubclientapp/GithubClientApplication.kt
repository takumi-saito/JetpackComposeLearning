package com.example.githubclientapp

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class GithubClientApplication : Application() {
    override fun onCreate() {
        super.onCreate()
    }
}