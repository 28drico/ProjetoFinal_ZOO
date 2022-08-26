package br.com.zup.projetofinalindividual.ui.listaAnimal.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import br.com.zup.projetofinalindividual.data.model.AnimalResult
import br.com.zup.projetofinalindividual.domain.model.SingleLiveEvent
import br.com.zup.projetofinalindividual.domain.usecase.AnimalUseCase
import br.com.zup.projetofinalindividual.viewstate.ViewState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ListaAnimalViewModel():ViewModel(){

    private val animalUsecase = AnimalUseCase()
    val animalList = SingleLiveEvent<ViewState<List<AnimalResult>>>()

    fun getAllAnimalNetwork(){
        viewModelScope.launch {
            animalList.value = ViewState.loading(null)
            try {
                val withContext = withContext(Dispatchers.Default){
                    animalUsecase.getAllAnimais()
//                    animalUsecase.getAllAnimaisNetwork()
                }
                withContext?.let {
                    animalList.value = ViewState.success(it.data)
                }
            }catch (ex : Exception){
                animalList.value = ViewState.error(null,ex.message)
            }
        }
    }
    class MenuViewModelFactory(): ViewModelProvider.Factory{
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if(modelClass.isAssignableFrom(ListaAnimalViewModel::class.java)){
                return ListaAnimalViewModel() as T
            }
            throw IllegalArgumentException("unknown viewmodel class")
        }
    }

}