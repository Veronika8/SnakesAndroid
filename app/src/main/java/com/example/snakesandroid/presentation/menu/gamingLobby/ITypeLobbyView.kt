package com.example.snakesandroid.presentation.menu.gamingLobby

import com.example.snakesandroid.domain.repositories.models.Player

interface ITypeLobbyView {
    fun bind(data: Player)
}