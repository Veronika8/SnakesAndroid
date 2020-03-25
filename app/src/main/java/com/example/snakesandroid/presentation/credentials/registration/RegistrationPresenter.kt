package com.example.snakesandroid.presentation.credentials.registration

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.example.snakesandroid.presentation.main.MainActivity
import com.example.snakesandroid.base.SubRX
import com.example.snakesandroid.domain.repositories.UserRepository
import javax.inject.Inject

@InjectViewState
class RegistrationPresenter : MvpPresenter<IRegistrationView> {

    @Inject
    lateinit var userRepository: UserRepository

    @Inject
    constructor()
    
    fun registration(login: String, pass: String) {

        viewState.lock()
        userRepository.registration(SubRX { _, e ->
            viewState.unlock()

            if (e != null) {
                e.printStackTrace()
                viewState.onError(e.localizedMessage)
                return@SubRX
            }

            MainActivity.show()

        }, login, pass)
    }
}