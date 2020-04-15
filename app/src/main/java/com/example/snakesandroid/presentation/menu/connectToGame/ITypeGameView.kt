package com.example.snakesandroid.presentation.menu.connectToGame

import com.example.snakesandroid.domain.repositories.models.DialogGame

interface ITypeGameView {
    fun bind(data: DialogGame)
}