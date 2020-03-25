package com.example.snakesandroid.presentation.credentials

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.example.snakesandroid.App
import com.example.snakesandroid.R
import com.example.snakesandroid.base.ABaseActivity
import com.example.snakesandroid.domain.repositories.local.UserStorage
import com.example.snakesandroid.presentation.credentials.authorization.AuthorizationFragment
import com.example.snakesandroid.presentation.credentials.loading.LoadingFragment
import com.example.snakesandroid.presentation.credentials.registration.RegistrationFragment

class CredentialsActivity : ABaseActivity(), ICredentialsRouter {

    companion object {

        private const val ARG_DROP_CREDENTIALS = "ARG_DROP_CREDENTIALS"

        fun show() {
            App.appContext.let {
                it.startActivity(Intent(it, CredentialsActivity::class.java).apply {
                    flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                    putExtra(ARG_DROP_CREDENTIALS, true)
                })
            }
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_container)

        if (savedInstanceState != null)
            return

        if (intent.getBooleanExtra(ARG_DROP_CREDENTIALS, false)) {
            UserStorage().dropCredentials()
            showAuthorization()
            return
        }
        showLoading()
    }

  //  override fun getContainer(): Int = R.id.container

    override fun showLoading() {
        replace(LoadingFragment())
    }

    override fun showRegistration() {
        replace(RegistrationFragment(), "Registration")
    }

    override fun showAuthorization() {
        replace(AuthorizationFragment())
    }
}