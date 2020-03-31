package com.example.snakesandroid.presentation.menu.mainMenu

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.snakesandroid.R
import com.example.snakesandroid.base.ABaseFragment
import com.example.snakesandroid.presentation.menu.IMenuRouter
import kotlinx.android.synthetic.main.fragment_menu.*

class MenuFragment : ABaseFragment() {

    override fun inject() {

    }

    override fun getViewId() = R.layout.fragment_menu

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnCreateGame.setOnClickListener {

            activity?.let {
                if (it is IMenuRouter)
                    it.showCreateGame()
            }
        }

        btnConnectGame.setOnClickListener {

            activity?.let {
                if (it is IMenuRouter)
                    it.showConnectGame()
            }
        }
    }

}
