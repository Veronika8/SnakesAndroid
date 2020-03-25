package com.example.snakesandroid.presentation.credentials

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.example.snakesandroid.R
import com.example.snakesandroid.base.ABaseActivity
import com.example.snakesandroid.presentation.credentials.authorization.AuthorizationFragment
import com.example.snakesandroid.presentation.credentials.loading.LoadingFragment
import com.example.snakesandroid.presentation.credentials.registration.RegistrationFragment

class CredentialsActivity : ABaseActivity(), ICredentialsRouter {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_container)

        if (savedInstanceState != null)
            return

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