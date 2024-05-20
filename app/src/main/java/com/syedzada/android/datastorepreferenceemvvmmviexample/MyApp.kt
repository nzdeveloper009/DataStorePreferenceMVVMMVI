package com.syedzada.android.datastorepreferenceemvvmmviexample

import android.app.Application
import com.syedzada.android.datastorepreferenceemvvmmviexample.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyApp : Application() {

    override fun onCreate() {
        super.onCreate()
        initKoin()
    }

    private fun initKoin() {
        startKoin {
            androidContext(this@MyApp)
            modules(appModule)
        }
    }
}