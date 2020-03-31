package com.example.snakesandroid.presentation.credentials.registration

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.arellomobile.mvp.MvpAppCompatFragment
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.example.snakesandroid.R
import com.example.snakesandroid.base.ABaseFragment
import com.example.snakesandroid.domain.di.components.DaggerAppComponent
import com.example.snakesandroid.presentation.credentials.ICredentialsRouter
import kotlinx.android.synthetic.main.fragment_authorization.*
import kotlinx.android.synthetic.main.fragment_registration.*
import kotlinx.android.synthetic.main.fragment_registration.etLogin
import kotlinx.android.synthetic.main.fragment_registration.etPassword
import javax.inject.Inject

class RegistrationFragment: ABaseFragment(), IRegistrationView {

    @Inject
    @InjectPresenter
    lateinit var presenter: RegistrationPresenter

    @ProvidePresenter //реализация для даггер
    fun providePresenter() = presenter

    override fun inject() {
        DaggerAppComponent.create().inject(this)
    }

    override fun getViewId() = R.layout.fragment_registration

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnAuth.setOnClickListener {
            presenter.registration("${etLogin.text}", "${etPassword.text}")
        }
    }

    override fun showAuthorization() {
        activity?.let {
            if (it is ICredentialsRouter)
                it.showAuthorization()
        }
    }
}
