package com.jorgeSM.apimarvel.presentation.mapper

import com.jorgeSM.apimarvel.data.remote.dto.ResultDTO
import com.jorgeSM.apimarvel.domain.mapper.transform
import com.jorgeSM.apimarvel.domain.models.Result
import com.jorgeSM.apimarvel.presentation.modelVO.ResultVO


fun Result.transformToVO() = ResultVO(
    id = this.id,
    name = this.name,
    description = this.description,
    modified = this.modified,
    image = this.thumbnail?.path + "." + this.thumbnail?.extension,
    resourceURI = this.resourceURI,
    comics = this.comics,
    series = this.series,
    stories = this.stories,
    events = this.events
)

fun ResultDTO.transformToVO() = ResultVO(
    id = this.id,
    name = this.name,
    description = this.description,
    modified = this.modified,
    image = this.thumbnail?.path + "." + this.thumbnail?.extension,
    resourceURI = this.resourceURI,
    comics = this.comics?.transform(),
    series = this.series?.transform(),
    stories = this.stories?.transform(),
    events = this.events?.transform()
)

