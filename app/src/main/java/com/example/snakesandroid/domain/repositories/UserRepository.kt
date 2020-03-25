package com.example.snakesandroid.domain.repositories

import com.example.snakesandroid.base.SubRX
import com.example.snakesandroid.base.standardSubscribeIO
import com.example.snakesandroid.domain.di.models.Token
import com.example.snakesandroid.domain.di.models.User
import com.example.snakesandroid.domain.repositories.local.UserStorage
import com.example.snakesandroid.domain.repositories.rest.api.UserRestApi
import java.util.*
import javax.inject.Inject

class UserRepository {

    private val storage: UserStorage
    private val rest: UserRestApi

    @Inject
    constructor(storage: UserStorage, rest: UserRestApi) {
        this.storage = storage
        this.rest = rest
    }

    fun registration(observer: SubRX<User>, login: String, pass: String) {

        rest.registration(login, pass)
            .doOnNext { storage.save(it)}
            .standardSubscribeIO(observer)
    }
    fun login(observer: SubRX<User>, login: String, pass: String){

        rest.login(login, pass)
            .doOnNext { storage.save(it)}
            .standardSubscribeIO(observer)
    }

    fun getUser() = storage.user

    fun refreshToken(token: Token): Token {
        TODO("Not yet implemented")
    }
}