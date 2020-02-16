package com.koidev.remote.service.api

import com.koidev.remote.model.response.RedditResponse
import com.koidev.remote.utils.Constants
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface RedditApi {

    @GET(Constants.QUERY_REDDITS)
    fun getPaginatedReddits(
        @Query(Constants.QUERY_PAGINATE_AFTER) nextPage: Int,
        @Query(Constants.QUERY_LIMIT) limit: Int
    ): Single<RedditResponse>
}