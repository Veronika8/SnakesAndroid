package com.example.snakesandroid.presentation.menu.connectToGame

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpAppCompatFragment
import com.arellomobile.mvp.MvpPresenter
import com.example.snakesandroid.domain.repositories.DialogsRepository
import javax.inject.Inject

@InjectViewState
class ConnectGamePresenter: MvpPresenter<IConnectGameView> {

    private val repository: DialogsRepository

    @Inject
    constructor(repository: DialogsRepository) {
        this.repository = repository
    }

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()


    }
}