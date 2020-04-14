package com.example.snakesandroid.presentation.menu.gamingLobby

import android.content.Context
import android.util.AttributeSet
import com.example.snakesandroid.R
import com.example.snakesandroid.base.ABaseView
import com.example.snakesandroid.domain.repositories.models.Player
import kotlinx.android.synthetic.main.connect_player.view.*

class TypeLobbyView constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0)
    : ABaseView(context, attrs, defStyleAttr), ITypeLobbyView {

    override fun getViewId(): Int = R.layout.connect_player

    override fun bind(data: Player) {
        tvLogin.text = data.login
    }
}