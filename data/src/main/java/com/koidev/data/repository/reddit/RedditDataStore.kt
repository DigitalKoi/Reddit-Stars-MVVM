package com.koidev.data.repository.reddit

import com.koidev.data.model.RedditEntity
import io.reactivex.Completable
import io.reactivex.Maybe
import io.reactivex.Single

interface RedditDataStore {

    fun clear(): Completable

    fun fetchReddit(nextPage: Int): Single<RedditEntity>

    fun saveReddit(reddit: RedditEntity): Completable

    fun getReddit(): Maybe<RedditEntity>
}
