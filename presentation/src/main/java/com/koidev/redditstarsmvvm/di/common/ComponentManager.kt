package com.koidev.redditstarsmvvm.di.common

import com.koidev.redditstarsmvvm.di.component.MainComponent
import com.koidev.redditstarsmvvm.di.component.RedditListSubComponent

interface ComponentManager  {

    fun getMainComponent(): MainComponent

    fun createRedditListSubComponent(): RedditListSubComponent

    fun releaseRedditSubComponent()
}