package com.koidev.data.store

import com.koidev.data.model.RedditEntity
import com.koidev.data.repository.reddit.RedditCache
import com.koidev.data.repository.reddit.RedditDataStore
import io.reactivex.Completable
import io.reactivex.Maybe
import io.reactivex.Single

open class RedditCacheDataStore(private val cache: RedditCache) : RedditDataStore {

    override fun clear(): Completable {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun saveReddit(reddit: RedditEntity): Completable {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getReddit(): Maybe<RedditEntity> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun fetchReddit(nextPage: Int): Single<RedditEntity> {
        throw UnsupportedOperationException()
    }


}