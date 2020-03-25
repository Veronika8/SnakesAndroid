package com.example.snakesandroid.base

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.snakesandroid.R

abstract class ABaseActivity : AppCompatActivity() {

    //abstract fun getContainer(): Int

    fun replace(fragment: Fragment, backStack: String? = null, tag: String? = null) {

        supportFragmentManager.beginTransaction()
            .replace(R.id.container, fragment, tag).apply {
                backStack?.let { addToBackStack(it) }
            }
            .commit()
    }
}