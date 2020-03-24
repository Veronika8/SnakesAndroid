package com.example.snakesandroid.domain.di.components

import com.example.snakesandroid.presentation.credentials.authorization.AuthorizationFragment
import com.example.snakesandroid.presentation.credentials.registration.RegistrationFragment
import dagger.Component

@Component
interface AppComponent {

    fun inject(target: RegistrationFragment)
    fun inject(target: AuthorizationFragment)
}