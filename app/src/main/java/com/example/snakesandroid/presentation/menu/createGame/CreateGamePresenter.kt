package com.example.snakesandroid.presentation.menu.createGame

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.example.snakesandroid.domain.repositories.UserRepository
import javax.inject.Inject

@InjectViewState
class CreateGamePresenter: MvpPresenter<ICreateGameView> {

    @Inject
    lateinit var userRepository: UserRepository

    @Inject
    constructor()

    fun createGame(nameGame: String, numPlayers: Int) {

        userRepository.createGame({

            viewState.showGamingLobby()
        }, nameGame, numPlayers)
    }
}