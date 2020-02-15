package com.koidev.redditstarsmvvm.di.module

import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule constructor(context: Context) {

    private val appContext = context.applicationContext

    @Provides @Singleton
    fun provideAppContext(): Context = appContext
}