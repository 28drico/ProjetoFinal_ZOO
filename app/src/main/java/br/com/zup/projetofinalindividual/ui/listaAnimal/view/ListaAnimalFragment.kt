package br.com.zup.projetofinalindividual.ui.listaAnimal.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.zup.projetofinalindividual.ANIMAL_KEY
import br.com.zup.projetofinalindividual.R
import br.com.zup.projetofinalindividual.data.model.AnimalResponseItem
import br.com.zup.projetofinalindividual.databinding.FragmentListaAnimalBinding
import br.com.zup.projetofinalindividual.ui.listaAnimal.viewmodel.ListaAnimalViewModel
import br.com.zup.projetofinalindividual.viewstate.ViewState

class ListaAnimalFragment : Fragment() {

    private lateinit var binding: FragmentListaAnimalBinding

    private  val viewmodel: ListaAnimalViewModel by lazy {
        ViewModelProvider(this)[ListaAnimalViewModel::class.java]
    }

    private val adapter: AnimalAdapter by lazy {
        AnimalAdapter(arrayListOf(), this::irParaDetalheItemAnimal)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentListaAnimalBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpRvAnimais()

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewmodel.getAllAnimalNetwork()

    }

    private fun initObserver(){
        viewmodel.animalList.observe(this.viewLifecycleOwner){
            when(it){
                is ViewState.Success -> {
                    adapter.updateAnimalList(it.data.toMutableList())
                }
                is ViewState.Error -> {
                    Toast.makeText(
                        context,
                        "${it.throwable.message}",
                        Toast.LENGTH_LONG
                    ).show()
                }
                is ViewState.EmptyList -> {
                    Toast.makeText(
                        context,
                        "Error",
                        Toast.LENGTH_LONG
                    ).show()
                }
                else -> {}
            }
        }
    }
    private fun setUpRvAnimais(){
        initObserver()
        binding.rvListaAnimal.adapter = adapter
        binding.rvListaAnimal.layoutManager = LinearLayoutManager(context)
    }


    fun irParaDetalheItemAnimal(animalResult: AnimalResponseItem){
        val bundle = bundleOf(ANIMAL_KEY to animalResult)

        NavHostFragment.findNavController(this).navigate(
            R.id.action_listaAnimalFragment_to_detalheItemAnimalFragment,bundle
        )
    }
}