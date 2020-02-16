package com.koidev.remote.model.response

import com.google.gson.annotations.SerializedName

data class RedditResponse(

    @SerializedName("kind")
    val kind: String? = null,

    @SerializedName("data")
    val listing: ListingResponse? = null

)