package com.jorgeSM.apimarvel.data.remote.models

data class Data(
    val offset: Long? = null,
    val limit: Long? = null,
    val total: Long? = null,
    val count: Long? = null,
    val results: List<Result>? = null
)