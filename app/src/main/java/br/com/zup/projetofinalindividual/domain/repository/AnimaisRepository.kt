package br.com.zup.projetofinalindividual.domain.repository

import br.com.zup.projetofinalindividual.data.datasource.local.dao.AnimalDao
import br.com.zup.projetofinalindividual.data.datasource.remote.RetrofitService
import br.com.zup.projetofinalindividual.data.model.AnimalResponse
import br.com.zup.projetofinalindividual.data.model.AnimalResult

class AnimaisRepository(private val animalDao: AnimalDao) {

    fun getAllAnimal(): List<AnimalResult> = animalDao.getAllAnimal()

    fun insertAllAnimalDataBase(animaisList: List<AnimalResult>){
        animalDao.insertAllAnimais(animaisList)
    }

    suspend fun getAllAnimaisNetwork(): AnimalResponse{
        return RetrofitService.apiService.getAllAnimalNetwork()
    }
}