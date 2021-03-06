package com.example.snakesandroid.base

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.snakesandroid.R

abstract class ABaseActivity : AppCompatActivity() {

    open fun getContainer(): Int = R.id.container

    fun replace(fragment: Fragment, backStack: String? = null, tag: String? = null) {

        supportFragmentManager.beginTransaction()
            .replace(getContainer(), fragment, tag).apply {
                backStack?.let { addToBackStack(it) }
            }
            .commit()
    }
}