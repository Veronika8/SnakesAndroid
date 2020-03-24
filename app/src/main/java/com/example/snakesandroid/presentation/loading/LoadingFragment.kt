package com.example.snakesandroid.presentation.loading

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.example.snakesandroid.R
import com.example.snakesandroid.base.ABaseFragment
import javax.inject.Inject

class LoadingFragment : ABaseFragment(), ILoadingView {

    @Inject
    @InjectPresenter
    lateinit var presenter: LoadingPresenter

    @ProvidePresenter
    fun providePresenter() = presenter

    override fun inject() {
    }

    override fun getViewId() = R.layout.fragment_loading

    override fun onLoadingComplete() {
        activity?.let {

        }
    }
}
