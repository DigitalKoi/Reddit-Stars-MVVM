package com.koidev.domain.interactor

import com.koidev.domain.base.SingleUseCase
import com.koidev.domain.executor.PostExecutionThread
import com.koidev.domain.model.reddit.Reddit
import com.koidev.domain.repository.RedditRepository
import io.reactivex.Single

open class GetRedditPosts(
    private val redditRepository: RedditRepository,
    postExecutionThread: PostExecutionThread
): SingleUseCase<Reddit, Int>(postExecutionThread) {

    override fun buildUseCaseObservable(params: Int?): Single<Reddit> =
        when {
            params != null -> {
                redditRepository.fetchReddit(params)
            }
            else -> throw IllegalArgumentException("Page count is supposed to be non null")
        }
}