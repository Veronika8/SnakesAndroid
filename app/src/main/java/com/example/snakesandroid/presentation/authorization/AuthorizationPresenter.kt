package com.example.snakesandroid.presentation.authorization

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.example.snakesandroid.repositories.UserRepository
import kotlin.math.log

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