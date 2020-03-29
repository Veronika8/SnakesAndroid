package com.example.snakesandroid.domain.repositories.rest.service

import com.example.snakesandroid.domain.repositories.models.rest.Token
import com.example.snakesandroid.domain.repositories.models.rest.User
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.PUT

interface IUserRestApiService {

    /**
     * Регистрация нового профиля пользователя
     */
    @PUT("/user/v1/registration")
    fun registration(@Body user: User): Observable<User>


    /**
     * Авторизация пользователя по существующему профилю
     */
    @POST("/user/v1/login")
    fun login(@Body user: User): Observable<User>


    /**
     * Будет использовать для обновления текущего токена пользователя
     *
     *  Получить токен можно, если задать: grantType="refresh_token" и refresh_token
     */
    @POST("/user/v1/refresh")
    fun refreshToken(
        @Header("refresh_token") refreshToken: String
    ): Call<Token>
}