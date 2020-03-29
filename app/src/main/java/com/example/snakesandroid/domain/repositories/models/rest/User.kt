package com.example.snakesandroid.domain.repositories.models.rest

import com.example.snakesandroid.domain.repositories.models.rest.Token
import com.google.gson.annotations.SerializedName

data class User (
    val id: Int? = null,
    val login: String,
    val password: String,

    @SerializedName("avatar_url")
    val avatarUrl: String? = null,
    var token: Token? = null
)