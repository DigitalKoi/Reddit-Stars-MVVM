package com.koidev.redditstarsmvvm.di.common

import android.content.Context
import com.koidev.redditstarsmvvm.BuildConfig
import com.koidev.redditstarsmvvm.di.component.DaggerMainComponent
import com.koidev.redditstarsmvvm.di.component.MainComponent
import com.koidev.redditstarsmvvm.di.module.AppModule
import com.koidev.redditstarsmvvm.di.module.NetworkModule

class DefaultComponentManager (context: Context) : ComponentManager {

    private val mainComponent = DaggerMainComponent.builder()
        .appModule(AppModule(context))
        .networkModule(NetworkModule(BuildConfig.HOST))
        .build()


    // region CREATING COMPONENTS

    override fun getMainComponent(): MainComponent = mainComponent

    // endregion

    // region RELEASE COMPONENTS
    // endregion
}