package com.example.snakesandroid.presentation.authorization

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.NavHostFragment
import com.arellomobile.mvp.MvpAppCompatFragment
import com.arellomobile.mvp.presenter.InjectPresenter
import com.example.snakesandroid.R
import kotlinx.android.synthetic.main.fragment_authorization.*

class AuthorizationFragment : MvpAppCompatFragment(), IAuthorizationView {

    @InjectPresenter
    lateinit var presenter: AuthorizationPresenter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_authorization, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnLogin.setOnClickListener {
            presenter.authorization("${etLogin.text}", "${etPassword.text}")
        }

        btnAuth.setOnClickListener {
            NavHostFragment.findNavController(this).navigate(R.id.registrationFragment)
        }
    }

    override fun showError(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_LONG).show()
    }
}
