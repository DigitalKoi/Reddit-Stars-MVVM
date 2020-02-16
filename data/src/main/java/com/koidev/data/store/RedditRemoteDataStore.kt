package com.koidev.data.store

import com.koidev.data.model.RedditEntity
import com.koidev.data.repository.reddit.RedditDataStore
import com.koidev.data.repository.reddit.RedditRemote
import io.reactivex.Completable
import io.reactivex.Maybe
import io.reactivex.Single

open class RedditRemoteDataStore(private val remote: RedditRemote) : RedditDataStore {

    override fun fetchReddit(nextPage: Int): Single<RedditEntity> = remote
        .fetchReddit(nextPage)

    override fun clear(): Completable {
        throw UnsupportedOperationException()
    }

    override fun saveReddit(reddit: RedditEntity): Completable {
        throw UnsupportedOperationException()
    }

    override fun getReddit(): Maybe<RedditEntity> {
        throw UnsupportedOperationException()
    }


}