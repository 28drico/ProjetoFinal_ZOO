package br.com.zup.projetofinalindividual.ui.detalhe

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import br.com.zup.projetofinalindividual.databinding.FragmentDetalheItemAnimalBinding
import br.com.zup.projetofinalindividual.ui.home.view.HomeActivity

class DetalheItemAnimalFragment : Fragment() {

    private lateinit var binding: FragmentDetalheItemAnimalBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
      binding = FragmentDetalheItemAnimalBinding.inflate(inflater, container, false)
        (activity as HomeActivity).supportActionBar?.setDisplayHomeAsUpEnabled(true)
        return binding.root
    }
}