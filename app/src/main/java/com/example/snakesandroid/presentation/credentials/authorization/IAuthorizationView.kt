package com.example.snakesandroid.presentation.credentials.authorization

import com.arellomobile.mvp.MvpView

interface IAuthorizationView: MvpView {

    fun showError(message: String)
}