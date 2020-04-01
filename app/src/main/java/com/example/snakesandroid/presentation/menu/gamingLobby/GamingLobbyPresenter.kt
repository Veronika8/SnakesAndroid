package com.example.snakesandroid.presentation.menu.gamingLobby

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.example.snakesandroid.domain.repositories.UserRepository
import javax.inject.Inject

@InjectViewState
class GamingLobbyPresenter: MvpPresenter<IGamingLobby> {

    @Inject
    lateinit var userRepository: UserRepository

    @Inject
    constructor()
}