package com.jorgeSM.apimarvel.remote.models

data class Stories(
    val available: Long? = null,
    val collectionURI: String? = null,
    val items: List<StoriesItem>? = null,
    val returned: Long? = null
)