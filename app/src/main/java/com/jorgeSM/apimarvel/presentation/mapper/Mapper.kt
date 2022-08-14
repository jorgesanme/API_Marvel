package com.jorgeSM.apimarvel.presentation.mapper

import com.jorgeSM.apimarvel.presentation.modelVO.ResultVO
import com.jorgeSM.apimarvel.remote.models.Result


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

