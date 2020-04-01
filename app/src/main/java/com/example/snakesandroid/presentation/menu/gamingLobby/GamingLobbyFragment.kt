package com.example.snakesandroid.presentation.menu.gamingLobby

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter

import com.example.snakesandroid.R
import com.example.snakesandroid.base.ABaseFragment
import com.example.snakesandroid.domain.di.components.DaggerAppComponent
import javax.inject.Inject

class GamingLobbyFragment : ABaseFragment(), IGamingLobby {

    @Inject
    @InjectPresenter
    lateinit var presenter: GamingLobbyPresenter

    @ProvidePresenter
    fun providePresenter() = presenter

    override fun inject() {
        DaggerAppComponent.create().inject(this)
    }

    override fun getViewId() = R.layout.fragment_gaming_lobby

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}
