package com.example.snakesandroid.presentation.menu.gamingLobby

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter

import com.example.snakesandroid.R
import com.example.snakesandroid.base.ABaseAdapter
import com.example.snakesandroid.base.ABaseFragment
import com.example.snakesandroid.base.ABaseListFragment
import com.example.snakesandroid.domain.di.components.DaggerAppComponent
import com.example.snakesandroid.domain.repositories.models.Player
import javax.inject.Inject

class GamingLobbyFragment : ABaseListFragment<Player, RecyclerView.ViewHolder>(), IGamingLobby {

    class Adapter: ABaseAdapter<Player, RecyclerView.ViewHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

            val view = TypeLobbyView(parent.context)
            view.layoutParams = ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
            return object : RecyclerView.ViewHolder(view) { }
        }

        override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
            val view = holder.itemView
            if (view is ITypeLobbyView)
                view.bind(data[position])
        }
    }

    override fun getListId(): Int = R.id.rvList_player
    override fun getViewId(): Int = R.layout.fragment_gaming_lobby

    @Inject
    @InjectPresenter
    lateinit var presenter: GamingLobbyPresenter

    @ProvidePresenter
    fun providePresenter() = presenter

    private val adapter = Adapter()
    override fun provideAdapter() = adapter

    override fun inject() {
        DaggerAppComponent.create().inject(this)
    }

    override fun bindPlayer(players: List<Player>) {
        adapter.data = players.toMutableList()
    }
}
