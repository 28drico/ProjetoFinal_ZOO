package br.com.zup.projetofinalindividual.ui.listaFavorito

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.zup.projetofinalindividual.R
import br.com.zup.projetofinalindividual.databinding.FragmentListaAnimalBinding
import br.com.zup.projetofinalindividual.databinding.FragmentListaFavoritoBinding

class ListaFavoritoFragment : Fragment() {

    private lateinit var binding: FragmentListaFavoritoBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentListaFavoritoBinding.inflate(inflater, container, false)
        return binding.root
    }
}