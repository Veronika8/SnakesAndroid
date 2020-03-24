package com.example.snakesandroid.repositories

import javax.inject.Inject

class UserRepository {

    @Inject
    constructor()

    fun registration(subscriber: (String) -> Unit, login: String, pass: String) {

        subscriber.invoke("$login : $pass")
    }
    fun authorization(subscriber: (String) -> Unit, login: String, pass: String){
        subscriber.invoke("$login : $pass")
    }
}