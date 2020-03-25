package com.example.snakesandroid.presentation.credentials.registration

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.example.snakesandroid.domain.repositories.UserRepository
import javax.inject.Inject

@InjectViewState
class RegistrationPresenter : MvpPresenter<IRegistrationView> {

    @Inject
    lateinit var userRepository: UserRepository

    @Inject
    constructor()
    
    fun registration(login: String, pass: String) {
        //
        
        userRepository.registration({
            //
            //
            viewState.showError(it)
        }, login, pass)
    }
}