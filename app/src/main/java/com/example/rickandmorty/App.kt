package com.example.rickandmorty

import android.app.Application
import com.example.rickandmorty.data.module.appModule
import com.example.rickandmorty.ui.module.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(appModule, viewModelModule)
        }
    }
}