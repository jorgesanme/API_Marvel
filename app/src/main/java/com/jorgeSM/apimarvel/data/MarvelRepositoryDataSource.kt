package com.jorgeSM.apimarvel.data

import com.jorgeSM.apimarvel.data.remote.dto.CharacterItemByIdRequestDTO
import com.jorgeSM.apimarvel.data.remote.dto.CharacterResponseDTO
import com.jorgeSM.apimarvel.data.remote.dto.ListOfCharacterRequestDTO


interface MarvelRepositoryDataSource {
    suspend fun getCharacterList(request: ListOfCharacterRequestDTO): List<CharacterResponseDTO?>
    suspend fun geCharacterById(request: CharacterItemByIdRequestDTO): CharacterResponseDTO?
}