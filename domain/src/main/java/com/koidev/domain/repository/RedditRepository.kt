package com.koidev.domain.repository

import com.koidev.domain.model.reddit.Reddit
import io.reactivex.Single

interface RedditRepository {

    fun fetchReddit(nextPage: Int): Single<Reddit>
}