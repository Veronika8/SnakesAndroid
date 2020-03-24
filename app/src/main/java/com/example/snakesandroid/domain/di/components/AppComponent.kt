package com.example.snakesandroid.domain.di.components

import com.example.snakesandroid.presentation.registration.RegistrationFragment
import dagger.Component

@Component
interface AppComponent {

    fun inject(target: RegistrationFragment)
}