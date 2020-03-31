package com.example.snakesandroid.presentation.credentials.authorization

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
import javax.inject.Inject

class AuthorizationFragment : ABaseFragment(), IAuthorizationView {

    @Inject
    @InjectPresenter
    lateinit var presenter: AuthorizationPresenter

    @ProvidePresenter
    fun providePresenter() = presenter

    override fun inject() {
        DaggerAppComponent.create().inject(this)
    }

    override fun getViewId() = R.layout.fragment_authorization

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnLogin.setOnClickListener {

            val login = "${etLogin.text}"
            val password = "${etPassword.text}"

            if (login.isEmpty() || password.isEmpty()) {
                toast(R.string.error_login_passwd_undefined)
                return@setOnClickListener
            }

            presenter.authorization(login, password)
        }

        btnRegistration.setOnClickListener {
            activity?.let {
                if (it is ICredentialsRouter)
                    it.showRegistration()
            }
        }
    }

    override fun lock() {
        visibility(flBtnContainer)
    }

    override fun unlock() {
        visibility(flBtnContainer, false)
    }

    override fun onSuccess() {
        toast("SUCCESS")
        // Отправить на главную форму
    }
}
