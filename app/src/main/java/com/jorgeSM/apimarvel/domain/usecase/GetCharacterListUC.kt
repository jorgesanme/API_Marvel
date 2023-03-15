package com.jorgeSM.apimarvel.domain.usecase

import com.jorgeSM.apimarvel.data.MarvelRepositoryImp
import com.jorgeSM.apimarvel.data.remote.dto.CharacterResponseDTO
import com.jorgeSM.apimarvel.domain.mapper.transform
import com.jorgeSM.apimarvel.domain.models.ListOfCharacterRequest


class GetCharacterListUC(
    private val repositoryImp: MarvelRepositoryImp = MarvelRepositoryImp()
) {


    suspend operator fun invoke(request: ListOfCharacterRequest): List<CharacterResponseDTO?> =
        repositoryImp.getCharacterList(request.transform())

}