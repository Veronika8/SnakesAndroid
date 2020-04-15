package com.example.snakesandroid.domain.di.components

import com.example.snakesandroid.domain.di.modules.NetModule
import com.example.snakesandroid.presentation.credentials.authorization.AuthorizationFragment
import com.example.snakesandroid.presentation.credentials.loading.LoadingFragment
import com.example.snakesandroid.presentation.credentials.registration.RegistrationFragment
import com.example.snakesandroid.presentation.menu.connectToGame.ConnectGameFragment
import com.example.snakesandroid.presentation.menu.createGame.CreateGameFragment
import com.example.snakesandroid.presentation.menu.gamingLobby.GamingLobbyFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [
//   AppModule::class,
NetModule::class
])
interface AppComponent {

    fun inject(target: RegistrationFragment)
    fun inject(target: AuthorizationFragment)
    fun inject(target: LoadingFragment)
    fun inject(target: CreateGameFragment)
    fun inject(target: GamingLobbyFragment)
    fun inject(target: ConnectGameFragment)
}