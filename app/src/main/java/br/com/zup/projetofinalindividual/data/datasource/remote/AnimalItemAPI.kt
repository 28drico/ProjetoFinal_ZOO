package br.com.zup.projetofinalindividual.data.datasource.remote


import br.com.zup.projetofinalindividual.data.model.AnimalResponse
import retrofit2.http.GET

interface AnimalItemAPI {

    @GET("animals/rand/10")
    suspend fun getAllAnimalNetwork(): AnimalResponse

}