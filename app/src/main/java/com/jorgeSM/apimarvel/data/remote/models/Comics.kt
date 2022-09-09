package com.jorgeSM.apimarvel.data.remote.models

data class Comics(
    val available: Long? = null,
    val collectionURI: String? = null,
    val items: List<ComicsItem>? = null,
    val returned: Long? = null
)