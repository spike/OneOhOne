package com.github.spike.conehundredthirtyeight

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface CharactersApi {
    @GET("character/{id}")
    suspend fun getCharacterById(  
        @Path("id") id: Int
    ) : Response<GetCharacter>
}