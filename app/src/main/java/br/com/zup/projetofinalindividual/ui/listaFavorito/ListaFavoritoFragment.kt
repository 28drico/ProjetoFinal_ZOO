package br.com.zup.projetofinalindividual.ui.listaFavorito

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import br.com.zup.projetofinalindividual.databinding.FragmentListaFavoritoBinding
import br.com.zup.projetofinalindividual.ui.home.view.HomeActivity

class ListaFavoritoFragment : Fragment() {

    private lateinit var binding: FragmentListaFavoritoBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentListaFavoritoBinding.inflate(inflater, container, false)
        (activity as HomeActivity).supportActionBar?.setDisplayHomeAsUpEnabled(true)
        return binding.root
    }
}