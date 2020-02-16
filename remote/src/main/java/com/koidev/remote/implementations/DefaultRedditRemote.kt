package com.koidev.remote.implementations

import com.koidev.data.model.RedditEntity
import com.koidev.data.repository.reddit.RedditRemote
import com.koidev.remote.mapper.toEntity
import com.koidev.remote.model.response.RedditResponse
import com.koidev.remote.service.api.RedditApi
import com.koidev.remote.utils.Constants
import io.reactivex.Single

class DefaultRedditRemote(
    private val api: RedditApi
) : RedditRemote {

    override fun fetchReddit(nextPage: Int): Single<RedditEntity> = api
        .getPaginatedReddits(
            nextPage = nextPage,
            limit = Constants.DEFAULT_LIMIT
        ).map(RedditResponse::toEntity)
}