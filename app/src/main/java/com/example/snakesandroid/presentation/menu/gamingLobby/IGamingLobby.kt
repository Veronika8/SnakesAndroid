package com.example.snakesandroid.presentation.menu.gamingLobby

import com.arellomobile.mvp.MvpView
import com.example.snakesandroid.domain.repositories.models.Player

interface IGamingLobby: MvpView {

    fun bindPlayer(players: List<Player>)
}