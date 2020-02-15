package com.koidev.redditstarsmvvm.di.component

import com.koidev.redditstarsmvvm.di.module.AppModule
import dagger.Component
import javax.inject.Singleton

@Singleton @Component(modules = [
    AppModule::class
])
interface MainComponent  {


}