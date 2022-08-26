package br.com.zup.projetofinalindividual.data.datasource.remote


import br.com.zup.projetofinalindividual.data.model.AnimalResult
import br.com.zup.projetofinalindividual.data.model.MenuRequest
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers

interface AnimalItemAPI {

    @Headers("Content-Type: application/json")
    @GET("animals/rand")
    suspend fun getAllAnimalNetwork(@Body menu: MenuRequest): List<AnimalResult>
}