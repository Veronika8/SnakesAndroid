package com.example.snakesandroid.presentation.menu

import android.content.Intent
import android.os.Bundle
import com.example.snakesandroid.App
import com.example.snakesandroid.R
import com.example.snakesandroid.base.ABaseActivity
import com.example.snakesandroid.presentation.menu.connectToGame.ConnectGameFragment
import com.example.snakesandroid.presentation.menu.createGame.CreateGameFragment
import com.example.snakesandroid.presentation.menu.gamingLobby.GamingLobbyFragment
import com.example.snakesandroid.presentation.menu.mainMenu.MenuFragment

class MenuActivity : ABaseActivity(), IMenuRouter {

    companion object {

        fun show() {
            App.appContext.let {
                it.startActivity(Intent(it, MenuActivity::class.java).apply {
                    flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                })
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        if (savedInstanceState != null)
            return

        showMenu()
    }

    override fun showMenu() {
        replace(MenuFragment())
    }

    override fun showCreateGame() {
        replace(CreateGameFragment(), "Create")
    }

    override fun showConnectGame() {
        replace(ConnectGameFragment(), "Connect")
    }

    override fun showGamingLobby() {
        replace(GamingLobbyFragment(), "Lobby")
    }
}
