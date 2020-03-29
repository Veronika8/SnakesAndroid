package com.example.snakesandroid

import android.app.Application
import android.content.Context
import com.example.snakesandroid.domain.repositories.local.Migration
import io.realm.Realm
import io.realm.RealmConfiguration

class App : Application() {

    companion object {

        lateinit var appContext: Context
    }

    override fun onCreate() {
        super.onCreate()

        appContext = applicationContext

        initRealm()
    }

    private fun initRealm() {

        Realm.init(this)
        Realm.setDefaultConfiguration(RealmConfiguration.Builder()
            .deleteRealmIfMigrationNeeded()
       //     .schemaVersion(Migration.DB_VERSION)
       //     .migration(Migration())
            .build()
        )
    }
}