package com.example.snakesandroid.presentation.menu.gamingLobby

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.example.snakesandroid.domain.repositories.DialogsRepository
import javax.inject.Inject

@InjectViewState
class GamingLobbyPresenter: MvpPresenter<IGamingLobby> {

    private val repository: DialogsRepository

    @Inject
    constructor(repository: DialogsRepository) {
        this.repository = repository
    }

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

//        repository.loadDialogs {
//            viewState.bindPlayer(it)
//        }
    }
}