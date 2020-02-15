package com.koidev.redditstarsmvvm.di.common

import com.koidev.redditstarsmvvm.di.component.MainComponent

interface ComponentManager  {

    fun getMainComponent(): MainComponent
}