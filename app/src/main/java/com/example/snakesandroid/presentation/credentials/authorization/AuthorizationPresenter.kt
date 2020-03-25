package com.example.snakesandroid.presentation.credentials.authorization

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.example.snakesandroid.domain.repositories.UserRepository
import javax.inject.Inject

@InjectViewState
class AuthorizationPresenter: MvpPresenter<IAuthorizationView> {

    @Inject
    lateinit var userRepository: UserRepository

    @Inject
    constructor()

    fun authorization(login: String, pass: String){

        userRepository.authorization({
            //
            viewState.showError(it)
        }, login, pass)
    }
}