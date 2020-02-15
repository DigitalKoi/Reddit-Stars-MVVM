package com.koidev.redditstarsmvvm

import android.app.Application
import com.koidev.redditstarsmvvm.di.common.ComponentManager
import com.koidev.redditstarsmvvm.di.common.DefaultComponentManager
import timber.log.Timber

class RedditApplication : Application() {

    private val componentManager by lazy { DefaultComponentManager(applicationContext) }

    override fun onCreate() {
        super.onCreate()
        initTimber()
    }

    fun getComponentManager(): ComponentManager = componentManager

    private fun initTimber() {
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}