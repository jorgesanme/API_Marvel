package com.jorgeSM.apimarvel.data.remote.dto

import com.squareup.moshi.JsonClass
import java.io.Serializable


@JsonClass(generateAdapter = true)
data class CharacterResponseDTO(
    val code: Long? = null,
    val status: String? = null,
    val copyright: String? = null,
    val attributionText: String? = null,
    val attributionHTML: String? = null,
    val eTag: String? = null,
    val data: DataDTO? = null
) : Serializable

data class DataDTO(
    val offset: Long? = null,
    val limit: Long? = null,
    val total: Long? = null,
    val count: Long? = null,
    val results: List<ResultDTO>? = null
)

data class ResultDTO(
    val id: Long? = null,
    val name: String? = null,
    val description: String? = null,
    val modified: String? = null, // FIXME: ver en doc si viene como long o Date
    val thumbnail: ThumbnailDTO? = null,
    val resourceURI: String? = null,
    val comics: ComicsDTO? = null,
    val series: SeriesDTO? = null,
    val stories: StoriesDTO? = null,
    val events: EventDTO? = null,
    val urls: List<URLDTO>? = null
)

data class ComicsDTO(
    val available: Long? = null,
    val collectionURI: String? = null,
    val items: List<ComicsItemDTO>? = null,
    val returned: Long? = null
)

data class SeriesDTO(
    val available: Long? = null,
    val collectionURI: String? = null,
    val items: List<SeriesItemDTO>? = null,
    val returned: Long? = null
)


data class StoriesDTO(
    val available: Long? = null,
    val collectionURI: String? = null,
    val items: List<StoriesItemDTO>? = null,
    val returned: Long? = null
)

data class EventDTO(
    val available: Long? = null,
    val collectionURI: String? = null,
    val items: List<EventsItemDTO>? = null,
    val returned: Long? = null
)

data class URLDTO(
    val type: String? = null,
    val url: String? = null
)

data class ComicsItemDTO(
    val resourceURI: String? = null,
    val name: String? = null
)

data class SeriesItemDTO(
    val resourceURI: String? = null,
    val name: String? = null
)

data class StoriesItemDTO(
    val resourceURI: String? = null,
    val name: String? = null,
    val type: String? = null
)

data class EventsItemDTO(
    val resourceURI: String? = null,
    val name: String? = null
)


data class ThumbnailDTO(
    val path: String? = null,
    val extension: String? = null
)














