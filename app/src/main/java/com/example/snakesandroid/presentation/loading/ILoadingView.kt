package com.example.snakesandroid.presentation.loading

import com.arellomobile.mvp.MvpView

interface ILoadingView : MvpView {

    fun onLoadingComplete()
}