package com.example.snakesandroid.presentation.credentials.registration

import com.arellomobile.mvp.MvpView

interface IRegistrationView: MvpView {

    fun showError(message: String)
}