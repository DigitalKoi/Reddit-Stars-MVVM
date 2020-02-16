package com.koidev.remote.model.response

import com.google.gson.annotations.SerializedName

data class ThingResponse(

    @SerializedName("kind")
    var kind: String? = null,

    @SerializedName("data")
    val data: SubRedditResponse? = null

)