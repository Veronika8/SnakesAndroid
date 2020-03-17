package com.example.snakesandroid.repositories

class UserRepository {
    fun registration(subscriber: (String) -> Unit, login: String, pass: String) {
        subscriber.invoke("$login : $pass")
    }
}