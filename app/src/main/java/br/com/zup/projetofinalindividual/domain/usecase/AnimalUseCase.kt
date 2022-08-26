package br.com.zup.projetofinalindividual.domain.usecase

import android.app.Application
import br.com.zup.projetofinalindividual.data.datasource.local.database.AnimalDatabase
import br.com.zup.projetofinalindividual.data.model.AnimalResult
import br.com.zup.projetofinalindividual.domain.repository.AnimaisRepository
import br.com.zup.projetofinalindividual.viewstate.ViewState

class AnimalUseCase(application: Application) {

    private val animalDao = AnimalDatabase.getAnimaisDataBase(application).animalDao()
    private val animaisRepository = AnimaisRepository(animalDao)

    suspend fun getAllAnimaisNetwork(): ViewState<List<AnimalResult>> {
        return try {
            val animal = animaisRepository.getAllAnimaisNetwork()
//            animaisRepository.insertAllAnimalDataBase(animal.animaisResult)
            ViewState.Success(animal.animaisResult)
        }catch (ex : Exception){
            getAllAnimais()
        }
    }

    fun getAllAnimais():ViewState<List<AnimalResult>>{
        return try {
            val animal = animaisRepository.getAllAnimal()
            if (animal.isEmpty()){
                ViewState.EmptyList(animal)
            }else{
                ViewState.Success(animal)
            }
        }catch (ex : Exception){
            ViewState.Error(Exception("Erro"))
        }
    }

//    fun getAllFavoritoAnimal(): ViewState<List<AnimalResult>>{
//        return try {
//            val animal = animaisRepository.getAllFavorito()
//            if (animal.isEmpty()){
//                ViewState.EmptyList(animal)
//            }else{
//                ViewState.Success(animal)
//            }
//        }catch (ex : Exception){
//            ViewState.Error(Exception("erro"))
//        }
//    }
//
//    fun updateFavoritoPersonagens(personagem: AnimalResult): ViewState<AnimalResult>{
//        return try {
//            animaisRepository.updateFavoritoPersonagens(personagem)
//            ViewState.Success(personagem)
//        }catch (ex : Exception){
//            ViewState.Error(Exception("erro"))
//        }
//    }
}