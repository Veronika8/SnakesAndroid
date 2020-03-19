package com.example.snakesandroid.presentation.registration

import com.arellomobile.mvp.MvpView

interface IRegistrationView: MvpView {

    fun showError(message: String)
}