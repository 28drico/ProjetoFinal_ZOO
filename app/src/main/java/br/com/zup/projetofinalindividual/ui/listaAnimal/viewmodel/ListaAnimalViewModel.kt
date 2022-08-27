package br.com.zup.projetofinalindividual.ui.listaAnimal.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import br.com.zup.projetofinalindividual.data.model.AnimalResponseItem
import br.com.zup.projetofinalindividual.data.model.AnimalResult
import br.com.zup.projetofinalindividual.domain.model.SingleLiveEvent
import br.com.zup.projetofinalindividual.domain.usecase.AnimalUseCase
import br.com.zup.projetofinalindividual.viewstate.ViewState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ListaAnimalViewModel(application: Application):AndroidViewModel(application){

    private val animalUsecase = AnimalUseCase(application)
    val animalList = SingleLiveEvent<ViewState<List<AnimalResponseItem>>>()

    fun getAllAnimalNetwork(){
        viewModelScope.launch {
            try {
                val response = withContext(Dispatchers.IO){
                    animalUsecase.getAllAnimais()
                    animalUsecase.getAllAnimaisNetwork()
                }
                    animalList.value = response

            }catch (ex : Exception){
                animalList.value = ViewState.Error(Exception("erro"))
            }
        }
    }
}