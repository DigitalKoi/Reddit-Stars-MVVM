package com.koidev.remote.model.response

import com.google.gson.annotations.SerializedName

data class ListingResponse(

    @SerializedName("modhash")
    val modhash: String? = null,

    @SerializedName("children")
    val things: List<ThingResponse>? = null,

    @SerializedName("after")
    val after: String? = null,

    @SerializedName("before")
    val before: Any? = null

)