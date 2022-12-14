package br.com.zup.projetofinalindividual.domain.repository

import br.com.zup.projetofinalindividual.data.datasource.local.dao.AnimalDao
import br.com.zup.projetofinalindividual.data.datasource.remote.RetrofitService
import br.com.zup.projetofinalindividual.data.model.AnimalResponse
import br.com.zup.projetofinalindividual.data.model.AnimalResponseItem

class AnimaisRepository(private val animalDao: AnimalDao) {

    fun getAllAnimal(): List<AnimalResponseItem> = animalDao.getAllAnimal()


    fun insertAllAnimalDataBase(animaisList: List<AnimalResponseItem>){
        animalDao.insertAllAnimais(animaisList)
    }

    suspend fun getAllAnimaisNetwork(): AnimalResponse {
        return RetrofitService.apiService.getAllAnimalNetwork()
    }

    fun getAllFavorito(): List<AnimalResponseItem> = animalDao.getAllFavoritoAnimal()

    fun updateFavoritoAnimal(animal: AnimalResponseItem){
        animalDao.updateFavoritoAnimal(animal)
    }
}