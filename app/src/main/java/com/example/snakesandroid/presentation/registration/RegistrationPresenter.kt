package com.example.snakesandroid.presentation.registration

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.example.snakesandroid.repositories.UserRepository

@InjectViewState
class RegistrationPresenter : MvpPresenter<IRegistrationView>() {
    var userRepository: UserRepository = UserRepository()
    
    fun registration(login: String, pass: String) {
        //gh
        
        userRepository.registration({
            //gg
            //gg
            viewState.showError(it)
        }, login, pass)
    }
}