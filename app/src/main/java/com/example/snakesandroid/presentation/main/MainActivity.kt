package com.example.snakesandroid.presentation.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.snakesandroid.App
import com.example.snakesandroid.R
import com.example.snakesandroid.base.ABaseActivity
import com.example.snakesandroid.presentation.credentials.CredentialsActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : ABaseActivity() {

    companion object {

        fun show() {
            App.appContext.let {
                it.startActivity(Intent(it, MainActivity::class.java).apply {
                    flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                })
            }
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if(savedInstanceState != null)
            return

       btnLogout.setOnClickListener {
           CredentialsActivity.show()
       }
    }
}
