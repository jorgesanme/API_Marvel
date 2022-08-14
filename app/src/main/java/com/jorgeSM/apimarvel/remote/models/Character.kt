package com.jorgeSM.apimarvel.remote.models

import com.squareup.moshi.JsonClass


@JsonClass(generateAdapter = true)
data class Character(
    val code: Long? = null,
    val status: String? = null,
    val copyright: String? = null,
    val attributionText: String? = null,
    val attributionHTML: String? = null,
    val etag: String? = null,
    val data: Data? = null
)
















