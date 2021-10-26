package com.example.githubclientapp.ui.view

import android.widget.SearchView
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.example.githubclientapp.model.User
import com.example.githubclientapp.viewmodel.MainViewModel

@Composable
fun MainView(mainViewModel: MainViewModel) {
    val uiState: MainViewModel.UIState by mainViewModel.uiState

    Column (Modifier.fillMaxWidth()) {
        SearchView(
            searchQuery = mainViewModel.searchQuery,
            onSearchButtonTapped = mainViewModel::onSearchTapped
        )
        when (uiState) {
            is MainViewModel.UIState.Initial -> {
                InitialView()
            }
            is MainViewModel.UIState.Loading -> {
                LoadingView()
            }
            is MainViewModel.UIState.Success -> {
                UserDetailView(user = uiState.requireUser())
            }
            is MainViewModel.UIState.Failure -> {
                ErrorView()
            }
        }
    }
}

private fun MainViewModel.UIState.requireUser(): User {
    if (this !is MainViewModel.UIState.Success) throw IllegalStateException("user is not loaded")
    return user
}