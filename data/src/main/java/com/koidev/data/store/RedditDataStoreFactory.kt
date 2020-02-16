package com.koidev.data.store

open class RedditDataStoreFactory (
    private val redditRemote: RedditRemoteDataStore,
    private val redditCache: RedditCacheDataStore
) {
    fun getRemote() = redditRemote
    fun getCache() = redditCache
}