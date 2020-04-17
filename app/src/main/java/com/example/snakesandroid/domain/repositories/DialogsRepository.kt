package com.example.snakesandroid.domain.repositories

import com.example.snakesandroid.domain.repositories.models.Player
import javax.inject.Inject

class DialogsRepository {

    @Inject
    constructor()

    fun loadPlayers(call: (List<Player>) -> Unit) {

    }
}