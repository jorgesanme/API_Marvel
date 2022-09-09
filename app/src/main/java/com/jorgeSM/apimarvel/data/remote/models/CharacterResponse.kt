package com.jorgeSM.apimarvel.data.remote.models

import com.squareup.moshi.JsonClass
import java.io.Serializable


@JsonClass(generateAdapter = true)
data class CharacterResponse(
    val code: Long? = null,
    val status: String? = null,
    val copyright: String? = null,
    val attributionText: String? = null,
    val attributionHTML: String? = null,
    val eTag: String? = null,
    val data: Data? = null
) : Serializable
















