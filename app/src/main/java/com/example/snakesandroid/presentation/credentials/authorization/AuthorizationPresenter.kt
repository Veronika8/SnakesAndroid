package com.example.snakesandroid.presentation.credentials.authorization

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.example.snakesandroid.repositories.UserRepository

@InjectViewState
class AuthorizationPresenter: MvpPresenter<IAuthorizationView>() {

    var userRepository: UserRepository= UserRepository()

    fun authorization(login: String, pass: String){
        //
        userRepository.authorization({
            //
            viewState.showError(it)
        }, login, pass)
    }
}