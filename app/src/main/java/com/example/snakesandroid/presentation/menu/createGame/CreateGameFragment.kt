package com.example.snakesandroid.presentation.menu.createGame

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.snakesandroid.R
import com.example.snakesandroid.base.ABaseFragment
import kotlinx.android.synthetic.main.fragment_create_game.*

class CreateGameFragment : ABaseFragment() {

    private var numPlayers: Int = 1

    override fun inject() {

    }

    override fun getViewId() = R.layout.fragment_create_game

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

            imgBtnPlus.setOnClickListener {
                tvNumPlayers.text = "${++numPlayers}"
            }

            imgBtnMinus.setOnClickListener {
                tvNumPlayers.text = "${--numPlayers}"
            }
    }

//    fun numPlus(view: View) {
//        val numPlayersStr = etNumPlayers.text.toString()
//        var numPlayers: Int = Integer.parseInt(numPlayersStr)
//        numPlayers++
//        etNumPlayers.text = numPlayers.toString()
//    }
}
