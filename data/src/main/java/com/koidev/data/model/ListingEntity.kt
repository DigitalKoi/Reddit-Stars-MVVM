package com.koidev.data.model

data class ListingEntity(

    var modhash: String? = null,

    val things: List<ThingEntity>? = null,

    val after: String? = null,

    val before: Any? = null

)