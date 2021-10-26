package com.example.githubclientapp.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.githubclientapp.model.repository.UserRepository
import com.example.githubclientapp.model.User
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val userRepository: UserRepository
) : ViewModel() {
    /**
     * Viewの状態を表す
     */
    sealed class UIState {
        /**
         * 初期状態
         */
        object Initial : UIState()

        /**
         * 読込中
         */
        object Loading : UIState()

        /**
         * 読み込み成功
         */
        data class Success(val user: User) : UIState()

        /**
         * 読み込み失敗
         */
        object Failure : UIState()
    }

    val uiState: MutableState<UIState> = mutableStateOf(UIState.Initial)

    val searchQuery: MutableState<String> = mutableStateOf("")

    /**
     * 検索実行
     */
    fun onSearchTapped() {
        val searchQuery: String = searchQuery.value

        viewModelScope.launch {
            uiState.value = UIState.Loading
            kotlin.runCatching {
                userRepository.getUser(userName = searchQuery)
            }.onSuccess {
                uiState.value = UIState.Success(user = it)
            }.onFailure {
                uiState.value = UIState.Failure
            }
        }
    }
}