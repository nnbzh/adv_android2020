package com.example.mvvmapplication.ui.common

sealed class State {
    object ShowLoading : State()
    object HideLoading : State()
    object Success : State()
}
