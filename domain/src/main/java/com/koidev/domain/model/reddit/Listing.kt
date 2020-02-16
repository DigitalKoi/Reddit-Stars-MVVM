package com.koidev.domain.model.reddit

data class Listing(

    var modhash: String? = null,

    val things: List<Thing>? = null,

    val after: String? = null,

    val before: Any? = null

)