package br.com.zup.projetofinalindividual.domain.repository

import br.com.zup.projetofinalindividual.data.datasource.local.dao.AnimalDao
import br.com.zup.projetofinalindividual.data.datasource.remote.RetrofitService
//import br.com.zup.projetofinalindividual.data.datasource.remote.RetrofitService
//import br.com.zup.projetofinalindividual.data.model.AnimaisResponse
import br.com.zup.projetofinalindividual.data.model.AnimalResult
import br.com.zup.projetofinalindividual.data.model.MenuRequest

class AnimaisRepository(private val animalDao: AnimalDao) {

//    fun getAllAnimal(): List<AnimalResult> = animalDao.getAllAnimal()
 suspend fun getAllAnimal(menu: MenuRequest): List<AnimalResult>{
    return RetrofitService.getAPI().getAllAnimalNetwork(menu)
}


    fun insertAllAnimalDataBase(animaisList: List<AnimalResult>){
        animalDao.insertAllAnimais(animaisList)
    }

//    suspend fun getAllAnimaisNetwork(): AnimaisResponse {
//        return RetrofitService.apiService.getAllAnimalNetwork()
//    }

    fun insertToCart(item:AnimalResult) = animalDao.insertIntoCart(item)

    fun updateCartList(item:AnimalResult)= animalDao.updateCartList(item)

    fun getCartList():List<AnimalResult> = animalDao.getCartList()
}