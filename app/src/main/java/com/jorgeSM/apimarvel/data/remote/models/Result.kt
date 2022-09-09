package com.jorgeSM.apimarvel.data.remote.models

data class Result(
    val id: Long? = null,
    val name: String? = null,
    val description: String? = null,
    val modified: String? = null, // FIXME: ver en doc si viene como long o Date
    val thumbnail: Thumbnail? = null,
    val resourceURI: String? = null,
    val comics: Comics? = null,
    val series: Comics? = null,
    val stories: Stories? = null,
    val events: Comics? = null,
    val urls: List<URL>? = null
)