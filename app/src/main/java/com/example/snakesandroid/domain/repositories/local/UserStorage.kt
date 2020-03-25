package com.example.snakesandroid.domain.repositories.local

import com.example.snakesandroid.domain.di.models.User
import javax.inject.Inject

class UserStorage {

    var user: User? = null
    private set

    @Inject
    constructor()

    fun save(user: User) {
        this.user = user
    }

    fun dropCredentials() {
        user = null
    }
}