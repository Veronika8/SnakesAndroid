package com.example.snakesandroid.domain.di.models

data class User (
    val id: Int,
    val login: String,
    val password: String,
    val avatar_url: String,
    val token: Token
)