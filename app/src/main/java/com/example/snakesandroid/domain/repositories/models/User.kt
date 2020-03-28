package com.example.snakesandroid.domain.repositories.models

data class User (
    val id: Int? = null,
    val login: String,
    val password: String,
    val avatar_url: String? = null,
    var token: Token? = null
)