package com.jorgeSM.apimarvel.presentation.modelVO

import com.jorgeSM.apimarvel.domain.models.Comics
import com.jorgeSM.apimarvel.domain.models.Event
import com.jorgeSM.apimarvel.domain.models.Series
import com.jorgeSM.apimarvel.domain.models.Stories
import java.io.Serializable

data class ResultVO(
    val id: Long? = null,
    val name: String? = null,
    val description: String? = null,
    val modified: String? = null,
    val image: String? = null,
    val resourceURI: String? = null,
    val comics: Comics? = null,
    val series: Series? = null,
    val stories: Stories? = null,
    val events: Event? = null
) : Serializable