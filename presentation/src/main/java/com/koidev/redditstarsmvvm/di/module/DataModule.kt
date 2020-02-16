package com.koidev.redditstarsmvvm.di.module

import com.koidev.data.repository.reddit.DefaultRedditRepository
import com.koidev.data.repository.reddit.RedditCache
import com.koidev.data.repository.reddit.RedditRemote
import com.koidev.data.store.RedditCacheDataStore
import com.koidev.data.store.RedditDataStoreFactory
import com.koidev.data.store.RedditRemoteDataStore
import com.koidev.domain.repository.RedditRepository
import com.koidev.remote.implementations.DefaultRedditRemote
import com.koidev.remote.service.api.RedditApi
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DataModule {

    @Provides @Singleton
    fun provideRedditRepository(
        factory: RedditDataStoreFactory
    ): RedditRepository = DefaultRedditRepository(
        factory = factory
    )

    @Provides @Singleton
    fun provideRedditDataStoreFactory(
        redditRemoteDataStore: RedditRemoteDataStore,
        redditCacheDataStore: RedditCacheDataStore
    ): RedditDataStoreFactory = RedditDataStoreFactory(
        redditRemote = redditRemoteDataStore,
        redditCache = redditCacheDataStore
    )

    @Provides @Singleton
    fun provideRedditCacheDataStore(
        redditCache: RedditCache
    ): RedditCacheDataStore = RedditCacheDataStore(
        cache = redditCache
    )

    @Provides @Singleton
    fun provideRedditRemoteDataStore(
        redditRemote: RedditRemote
    ): RedditRemoteDataStore = RedditRemoteDataStore(
        remote = redditRemote
    )

    @Provides @Singleton
    fun provideRedditRemote(api: RedditApi): RedditRemote = DefaultRedditRemote(
        api = api
    )
}