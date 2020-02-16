package com.koidev.data.repository.reddit

import com.koidev.data.model.RedditEntity
import io.reactivex.Single

interface RedditRemote {

    fun fetchReddit(
        nextPage: Int
    ): Single<RedditEntity>
}