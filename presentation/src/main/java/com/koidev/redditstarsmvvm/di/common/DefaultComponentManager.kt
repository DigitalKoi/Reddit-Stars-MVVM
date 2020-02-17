package com.koidev.redditstarsmvvm.di.common

import android.content.Context
import com.koidev.redditstarsmvvm.BuildConfig
import com.koidev.redditstarsmvvm.di.component.DaggerMainComponent
import com.koidev.redditstarsmvvm.di.component.MainComponent
import com.koidev.redditstarsmvvm.di.component.RedditListSubComponent
import com.koidev.redditstarsmvvm.di.module.AppModule
import com.koidev.redditstarsmvvm.di.module.NetworkModule
import com.koidev.redditstarsmvvm.di.module.RedditListModule

class DefaultComponentManager (context: Context) : ComponentManager {

    private val mainComponent = DaggerMainComponent.builder()
        .appModule(AppModule(context))
        .networkModule(NetworkModule(BuildConfig.HOST))
        .build()


    private var redditListSubComponent: RedditListSubComponent? = null


    // region CREATING COMPONENTS

    override fun getMainComponent(): MainComponent = mainComponent

    override fun createRedditListSubComponent(): RedditListSubComponent = mainComponent
        .plus(RedditListModule()).also { redditListSubComponent = it }

    // endregion


    // region RELEASE COMPONENTS

    override fun releaseRedditSubComponent() {
        redditListSubComponent = null
    }

    // endregion
}