package com.koidev.redditstarsmvvm.di.component

import com.koidev.redditstarsmvvm.di.module.AppModule
import com.koidev.redditstarsmvvm.di.module.NetworkModule
import com.koidev.redditstarsmvvm.di.module.RedditListModule
import dagger.Component
import javax.inject.Singleton

@Singleton @Component(modules = [
    AppModule::class,
    NetworkModule::class
])
interface MainComponent {

    fun plus(redditListModule: RedditListModule): RedditListSubComponent
}