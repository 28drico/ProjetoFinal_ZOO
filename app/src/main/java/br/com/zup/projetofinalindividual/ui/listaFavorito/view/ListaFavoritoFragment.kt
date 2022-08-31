package br.com.zup.projetofinalindividual.ui.listaFavorito.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.GridLayoutManager
import br.com.zup.projetofinalindividual.ANIMAL_KEY
import br.com.zup.projetofinalindividual.R
import br.com.zup.projetofinalindividual.data.model.AnimalResponseItem
import br.com.zup.projetofinalindividual.databinding.FragmentListaFavoritoBinding
import br.com.zup.projetofinalindividual.ui.listaFavorito.viewmodel.ListaFavoritoViewModel
import br.com.zup.projetofinalindividual.viewstate.ViewState

class ListaFavoritoFragment : Fragment() {

    private lateinit var binding: FragmentListaFavoritoBinding

    private val favoritoViewModel: ListaFavoritoViewModel by lazy {
        ViewModelProvider(this)[ListaFavoritoViewModel::class.java]
    }

    private val adapter: ListaFavoritoAdapter by lazy {
        ListaFavoritoAdapter(mutableListOf(),this::irParaDetalhe)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentListaFavoritoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onResume(){
        super.onResume()
        observe()
        favoritoViewModel.getAllAnimalFavorito()
        exibirListaFavorito()
    }

    private fun observe(){
        favoritoViewModel.animalListFavoritoState.observe(this){
            when(it){
                is ViewState.Success -> {
                    Log.i("List", "${it.data}")
                    adapter.updateFavoritoList(it.data.toMutableList())
                }
                is ViewState.Error -> {
                    Toast.makeText(
                        context,
                        "${it.throwable.message}",
                        Toast.LENGTH_LONG
                    ).show()
                }
                is ViewState.EmptyList -> {
                    adapter.updateFavoritoList(it.data.toMutableList())
                }
                else -> {}
            }
        }
    }

    private fun exibirListaFavorito(){
        binding.rvFavorite.adapter = adapter
        binding.rvFavorite.layoutManager = GridLayoutManager(context,2)
    }

    private fun irParaDetalhe(animal:AnimalResponseItem){
        val bundle = bundleOf(ANIMAL_KEY to animal)
        NavHostFragment.findNavController(this).navigate(
            R.id.action_listaFavoritoFragment_to_detalheItemAnimalFragment,bundle
        )
    }
}