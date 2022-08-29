package br.com.zup.projetofinalindividual.domain.usecase

import android.app.Application
import br.com.zup.projetofinalindividual.data.datasource.local.database.AnimalDatabase
import br.com.zup.projetofinalindividual.data.model.AnimalResponseItem
import br.com.zup.projetofinalindividual.domain.repository.AnimaisRepository
import br.com.zup.projetofinalindividual.viewstate.ViewState

class AnimalUseCase (application: Application){

    private val animalDao = AnimalDatabase.getAnimaisDataBase(application).animalDao()
    private val animaisRepository = AnimaisRepository(animalDao)

    suspend fun getAllAnimaisNetwork(): ViewState<List<AnimalResponseItem>> {
        return try {
            val animal = animaisRepository.getAllAnimaisNetwork()
            animaisRepository.insertAllAnimalDataBase(animal)
            ViewState.Success(animal)
        }catch (ex : Exception){
            getAllAnimais()
        }
    }

    fun getAllAnimais():ViewState<List<AnimalResponseItem>>{
        return try {
            val animal = animaisRepository.getAllAnimal()
                ViewState.Success(animal)
        }catch (ex : Exception){
            ViewState.Error(Exception("erro"))
        }
    }
}