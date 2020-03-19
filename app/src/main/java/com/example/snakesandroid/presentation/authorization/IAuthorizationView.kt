package com.example.snakesandroid.presentation.authorization

import com.arellomobile.mvp.MvpView

interface IAuthorizationView: MvpView {

    fun showError(message: String)
}