package com.koidev.redditstarsmvvm.di.module

import com.koidev.domain.interactor.GetRedditPosts
import com.koidev.domain.repository.RedditRepository
import com.koidev.redditstarsmvvm.global.UiThread
import com.koidev.redditstarsmvvm.mvvm.factory.RedditListVMFactory
import dagger.Module
import dagger.Provides

@Module
class RedditListModule {

    @Provides
    fun provideRedditListVMFactory(
        getRedditPosts: GetRedditPosts
    ) = RedditListVMFactory(
        getRedditPosts = getRedditPosts
    )

    @Provides
    fun provideGetRedditPosts(
        redditRepository: RedditRepository
    ) = GetRedditPosts(
        postExecutionThread = UiThread(),
        redditRepository = redditRepository
    )
}