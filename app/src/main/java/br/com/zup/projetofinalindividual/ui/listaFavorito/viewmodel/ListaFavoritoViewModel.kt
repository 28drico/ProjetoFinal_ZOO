package br.com.zup.projetofinalindividual.ui.listaFavorito.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import br.com.zup.projetofinalindividual.FALHA_CARREGAR
import br.com.zup.projetofinalindividual.FALHA_DISFAVORITA
import br.com.zup.projetofinalindividual.data.model.AnimalResponseItem
import br.com.zup.projetofinalindividual.domain.model.SingleLiveEvent
import br.com.zup.projetofinalindividual.domain.usecase.AnimalUseCase
import br.com.zup.projetofinalindividual.viewstate.ViewState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ListaFavoritoViewModel(application: Application): AndroidViewModel(application) {
    private val animalUsecase = AnimalUseCase(application)
    val animalListFavoritoState = SingleLiveEvent<ViewState<List<AnimalResponseItem>>>()
    val animalDisfavoritoState = SingleLiveEvent<ViewState<AnimalResponseItem>>()

    fun disfavorito(animal: AnimalResponseItem){
        viewModelScope.launch {
            try {
                val response = withContext(Dispatchers.IO){
                    animalUsecase.updateFavoritoAnimal(animal)
                }
                animalDisfavoritoState.value = response
            }catch (e : Exception){
                animalListFavoritoState.value =
                    ViewState.Error(Throwable(FALHA_DISFAVORITA))
            }
        }
    }

    fun getAllAnimalFavorito(){
        viewModelScope.launch {
            try {
                val response = withContext(Dispatchers.IO){
                    animalUsecase.getAllFavoritoAnimais()
                }
                animalListFavoritoState.value = response
            }catch (e : Exception){
                animalListFavoritoState.value =
                    ViewState.Error(Throwable(FALHA_CARREGAR))
            }
        }
    }
}