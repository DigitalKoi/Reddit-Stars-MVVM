package com.koidev.data.repository.reddit

import com.koidev.data.mapper.toDomain
import com.koidev.data.model.RedditEntity
import com.koidev.data.store.RedditDataStoreFactory
import com.koidev.domain.model.reddit.Reddit
import com.koidev.domain.repository.RedditRepository
import io.reactivex.Single

class DefaultRedditRepository(
    private val factory: RedditDataStoreFactory
) : RedditRepository {

    override fun fetchReddit(nextPage: Int): Single<Reddit> = factory
        .getRemote()
        .fetchReddit(nextPage)
        .map(RedditEntity::toDomain)
}