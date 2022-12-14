package com.jorgeSM.apimarvel.domain.usecase

import com.jorgeSM.apimarvel.data.MarvelRepositoryImp
import com.jorgeSM.apimarvel.data.remote.models.CharacterResponseDTO
import com.jorgeSM.apimarvel.data.remote.models.ListOfCharacterRequestDTO

/*****
 * Projecto: Api marvel
 * From: com.jorgeSM.apimarvel.domain.usecase
 * Create by Jorge S. Medina on 9/9/22 at 08:59
 * More info: https://www.linkedin.com/in/jorge-s%C3%A1nchez-medina-bb7b7371/
 *****/
class GetCharacterListUC(
    private val repositoryImp: MarvelRepositoryImp = MarvelRepositoryImp()
) {


    suspend operator fun invoke(request: ListOfCharacterRequestDTO): List<CharacterResponseDTO?> =
        repositoryImp.getCharacterList(request)

}