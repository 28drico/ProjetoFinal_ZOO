package br.com.zup.projetofinalindividual.ui.listaAnimal

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.zup.projetofinalindividual.R
import br.com.zup.projetofinalindividual.databinding.FragmentListaAnimalBinding

class ListaAnimalFragment : Fragment() {

    private lateinit var binding: FragmentListaAnimalBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentListaAnimalBinding.inflate(inflater, container, false)
        return binding.root
    }

}