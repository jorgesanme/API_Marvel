package com.jorgeSM.apimarvel.domain.usecase

import com.jorgeSM.apimarvel.data.MarvelRepositoryImp
import com.jorgeSM.apimarvel.data.remote.dto.CharacterResponseDTO
import com.jorgeSM.apimarvel.domain.mapper.transform
import com.jorgeSM.apimarvel.domain.models.CharacterItemByIdRequest


class GetCharacterByIdUC(
    private val repositoryImp: MarvelRepositoryImp = MarvelRepositoryImp()
) {
    suspend operator fun invoke(request: CharacterItemByIdRequest): CharacterResponseDTO? =
        repositoryImp.geCharacterById(request.transform())
}