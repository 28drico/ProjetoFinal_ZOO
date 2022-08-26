package br.com.zup.projetofinalindividual.ui.listaAnimal.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.zup.projetofinalindividual.ANIMAL_KEY
import br.com.zup.projetofinalindividual.R
import br.com.zup.projetofinalindividual.data.model.AnimalResult
import br.com.zup.projetofinalindividual.databinding.FragmentListaAnimalBinding
import br.com.zup.projetofinalindividual.ui.listaAnimal.viewmodel.ListaAnimalViewModel
import br.com.zup.projetofinalindividual.viewstate.Status
import br.com.zup.projetofinalindividual.viewstate.ViewState

class ListaAnimalFragment : Fragment() {

    private lateinit var binding: FragmentListaAnimalBinding
    private lateinit var viewmodel: ListaAnimalViewModel
    private lateinit var factory:ListaAnimalViewModel.MenuViewModelFactory

    private val adapter: AnimalAdapter by lazy {
        AnimalAdapter(arrayListOf(), this::irParaDetalheItemAnimal)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentListaAnimalBinding.inflate(inflater, container, false)
        factory = ListaAnimalViewModel.MenuViewModelFactory()
        viewmodel = ViewModelProvider(this,factory).get(ListaAnimalViewModel::class.java)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewmodel.getAllAnimalNetwork()

        viewmodel.animalList.observe(viewLifecycleOwner, Observer {
            when(it.status){
                Status.SUCCESS -> {
                    binding.rvListaAnimal.adapter = adapter
                    binding.rvListaAnimal.layoutManager = LinearLayoutManager(context)
                    adapter.updateAnimalList(it.data as ArrayList<AnimalResult>)
                    binding.rvListaAnimal.isVisible = true
                    binding.pbLoading.isVisible = false
                }
                Status.LOADING -> {
                    binding.pbLoading.isVisible = true
                    binding.rvListaAnimal.isVisible = false
                }
                Status.ERROR -> {
                    Toast.makeText( context,"${it.message}",Toast.LENGTH_LONG).show()
                    binding.pbLoading.isVisible = false
                }
                else -> {}
            }
        })
//        setUpRvAnimais()
    }

//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        viewmodel.getAllAnimalNetwork()
//    }

//    private fun initObserver(){
//        viewmodel.animalList.observe(this.viewLifecycleOwner){
//            when(it){
//                is ViewState.Success -> {
//                    adapter.updateAnimalList(it.data.toMutableList())
//                }
//                is ViewState.Error -> {
//                    Toast.makeText(
//                        context,
//                        "${it.throwable.message}",
//                        Toast.LENGTH_LONG
//                    ).show()
//                }
//                is ViewState.EmptyList -> {
//                    Toast.makeText(
//                        context,
//                        "Error",
//                        Toast.LENGTH_LONG
//                    ).show()
//                }
//                else -> {}
//            }
//        }
//    }
//    private fun setUpRvAnimais(){
//        initObserver()
//        binding.rvListaAnimal.adapter = adapter
//        binding.rvListaAnimal.layoutManager = LinearLayoutManager(context)
//    }


    fun irParaDetalheItemAnimal(animalResult: AnimalResult){
        val bundle = bundleOf(ANIMAL_KEY to animalResult)

        NavHostFragment.findNavController(this).navigate(
            R.id.action_listaAnimalFragment_to_detalheItemAnimalFragment,bundle
        )
    }
}