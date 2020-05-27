package com.example.snakesandroid.presentation.game

import com.arellomobile.mvp.MvpView

interface IGameView: MvpView {
    fun Left()
    fun Bottom()
    fun Top()
    fun Right()
}