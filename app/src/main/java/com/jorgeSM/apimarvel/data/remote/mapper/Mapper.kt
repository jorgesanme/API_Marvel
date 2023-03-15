package com.jorgeSM.apimarvel.domain.mapper

import com.jorgeSM.apimarvel.data.remote.dto.*
import com.jorgeSM.apimarvel.domain.models.*




fun CharacterItemByIdRequest.transform() = CharacterItemByIdRequestDTO(
    id = this.id,
    hast = this.hast

)

fun ListOfCharacterRequest.transform() = ListOfCharacterRequestDTO(
    hast = this.hast
)

fun CharacterResponseDTO.transform() = CharacterResponse(
    code = this.code,
    status = this.status,
    copyright = this.copyright,
    attributionText = this.attributionText,
    attributionHTML = this.attributionHTML,
    eTag = this.eTag,
    data = this.data?.transform()
)

fun DataDTO.transform() = Data(
    offset = this.offset,
    limit = this.limit,
    total = this.total,
    count = this.count,
    results = this.results?.map { it.transform() }
)

fun ResultDTO.transform() = Result(
    id = this.id,
    name = this.name,
    description = this.description,
    modified = this.modified, // FIXME: ver en doc si viene como long o Date
    thumbnail = this.thumbnail?.transform(),
    resourceURI = this.resourceURI,
    comics = this.comics?.transform(),
    series = this.series?.transform(),
    stories = this.stories?.transform(),
    events = this.events?.transform(),
    urls = this.urls?.map { it.transfrom() }
)

fun ComicsDTO.transform() = Comics(
    available = this.available,
    collectionURI = this.collectionURI,
    items = this.items?.map { it.transform() },
    returned = this.returned
)

fun SeriesDTO.transform() = Series(
    available = this.available,
    collectionURI = this.collectionURI,
    items = this.items?.map { it.transform() },
    returned = this.returned
)

fun StoriesDTO.transform() = Stories(
    available = this.available,
    collectionURI = this.collectionURI,
    items = this.items?.map { it.transform() },
    returned = this.returned
)

fun EventDTO.transform() = Event(
    available = this.available,
    collectionURI = this.collectionURI,
    items = this.items?.map { it.transform() },
    returned = this.returned
)


fun ThumbnailDTO.transform() = Thumbnail(
    path = this.path,
    extension = this.extension
)

fun URLDTO.transfrom() = URL(
    type = this.type,
    url = this.url
)

/** Items */

fun ComicsItemDTO.transform() = ComicsItem(
    resourceURI = this.resourceURI,
    name = this.name
)

fun SeriesItemDTO.transform() = SeriesItem(
    resourceURI = this.resourceURI,
    name = this.name
)

fun StoriesItemDTO.transform() = StoriesItem(
    resourceURI = this.resourceURI,
    name = this.name,
    type = this.type
)

fun EventsItemDTO.transform() = EventsItem(
    resourceURI = this.resourceURI,
    name = this.name
)