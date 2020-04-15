package com.example.snakesandroid.presentation.menu.connectToGame

import com.arellomobile.mvp.MvpView
import com.example.snakesandroid.domain.repositories.models.DialogGame

interface IConnectGameView: MvpView {

    fun bindGame(games: List<DialogGame>)
}