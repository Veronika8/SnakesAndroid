package com.example.snakesandroid.presentation.menu.connectToGame

import android.content.Context
import android.util.AttributeSet
import com.example.snakesandroid.R
import com.example.snakesandroid.base.ABaseView
import com.example.snakesandroid.domain.repositories.models.DialogGame
import kotlinx.android.synthetic.main.choose_game.view.*

class TypeGameView constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0)
    : ABaseView(context, attrs, defStyleAttr), ITypeGameView {

    override fun getViewId(): Int = R.layout.choose_game
    override fun bind(data: DialogGame) {
        tvTitle.text = data.title
        tvNumPlayers.text = data.numPlayers.toString()
        tvAllNumPlayers.text = data.allNumPlayers.toString()
    }
}