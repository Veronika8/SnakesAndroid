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
import kotlinx.android.synthetic.main.fragment_registration.*
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

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_registration, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnLogin.setOnClickListener {
            presenter.registration("${etLogin.text}", "${etPassword.text}")
        }
    }

    override fun showError(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_LONG).show()
    }
}
