package com.example.snakesandroid

import android.content.Intent
import android.os.Bundle
import com.example.snakesandroid.base.ABaseActivity
import com.example.snakesandroid.presentation.game.GameView
import com.example.snakesandroid.presentation.game.IGameView
import com.example.snakesandroid.presentation.game.ui.PlayingFieldUI
import kotlinx.android.synthetic.main.activity_game.*

class GameActivity : ABaseActivity(), IGameView {

    companion object {

        fun show() {
            App.appContext.let {
                it.startActivity(Intent(it, GameActivity::class.java).apply {
                    flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                })
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

        if(savedInstanceState != null)
            return

        left.setOnClickListener {
            Left()
        }
        bottom.setOnClickListener {
            Bottom()
        }
        top.setOnClickListener {
            Top()
        }
        right.setOnClickListener {
            Right()
        }
    }

    override fun Left() {
        PlayingFieldUI().setDirection(GameView.LEFT_DIRECTION)
    }

    override fun Bottom() {
        PlayingFieldUI().setDirection(GameView.BOTTOM_DIRECTION)
    }

    override fun Top() {
        PlayingFieldUI().setDirection(GameView.TOP_DIRECTION)
    }

    override fun Right() {
        PlayingFieldUI().setDirection(GameView.RIGHT_DIRECTION)
    }
}
