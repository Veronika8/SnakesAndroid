package com.example.snakesandroid.presentation.menu.createGame

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.example.snakesandroid.GameActivity

import com.example.snakesandroid.R
import com.example.snakesandroid.base.ABaseFragment
import com.example.snakesandroid.domain.di.components.DaggerAppComponent
import com.example.snakesandroid.presentation.menu.IMenuRouter
import kotlinx.android.synthetic.main.fragment_create_game.*
import javax.inject.Inject

class CreateGameFragment : ABaseFragment(), ICreateGameView {

    @Inject
    @InjectPresenter
    lateinit var presenter: CreateGamePresenter

    @ProvidePresenter
    fun providePresenter() = presenter

    override fun inject() {
        DaggerAppComponent.create().inject(this)
    }

    private var numPlayers: Int = 1

    override fun getViewId() = R.layout.fragment_create_game

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

            imgBtnPlus.setOnClickListener {
                if (numPlayers >= 8) {
                    toast(R.string.error_num_players)
                    return@setOnClickListener
                }
                tvNumPlayers.text = "${++numPlayers}"
            }

            imgBtnMinus.setOnClickListener {
                if (numPlayers <= 1) {
                    toast(R.string.error_num_players)
                    return@setOnClickListener
                }
                tvNumPlayers.text = "${--numPlayers}"
            }

        btnCreateGame.setOnClickListener {
            val nameGame = "${etNameGame.text}"
            val numPlayerStr: String = tvNumPlayers.text.toString()
            val numPlayer: Int = numPlayerStr.toInt()

            presenter.createGame(nameGame, numPlayer)
        }
    }

    override fun showGamingLobby() {
       activity?.let {
           if (it is IMenuRouter)
               it.showGamingLobby()
       }
    }
}
