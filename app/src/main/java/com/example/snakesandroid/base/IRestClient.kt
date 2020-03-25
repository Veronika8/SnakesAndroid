package com.example.snakesandroid.base

interface IRestClient {

    fun <S> createService(serviceClass: Class<S>): S

    fun cancelAllRequests()

}