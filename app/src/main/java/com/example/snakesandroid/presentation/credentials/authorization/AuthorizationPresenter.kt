package com.example.snakesandroid.presentation.credentials.authorization

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.example.snakesandroid.presentation.main.MainActivity
import com.example.snakesandroid.base.SubRX
import com.example.snakesandroid.domain.repositories.UserRepository
import javax.inject.Inject

@InjectViewState
class AuthorizationPresenter: MvpPresenter<IAuthorizationView> {

    @Inject
    lateinit var userRepository: UserRepository

    @Inject
    constructor()

    fun authorization(login: String, password: String){

        userRepository.login(SubRX { _, e ->

            if (e != null) {
                e.printStackTrace()
                viewState.onError(e.localizedMessage)
                return@SubRX
            }

            MainActivity.show()
        }, login, password)
    }
}