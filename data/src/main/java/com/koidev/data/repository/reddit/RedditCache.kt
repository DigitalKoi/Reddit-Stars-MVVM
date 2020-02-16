package com.koidev.data.repository.reddit

import com.koidev.domain.model.reddit.Reddit
import io.reactivex.Completable
import io.reactivex.Single

interface RedditCache {

    fun saveReddit(reddit: Reddit): Completable

    fun getReddti(): Single<Reddit>
}