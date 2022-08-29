package br.com.zup.projetofinalindividual.ui.detalhe

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import br.com.zup.projetofinalindividual.ANIMAL_KEY
import br.com.zup.projetofinalindividual.data.model.AnimalResponseItem
import br.com.zup.projetofinalindividual.databinding.FragmentDetalheItemAnimalBinding
import br.com.zup.projetofinalindividual.ui.listaAnimal.viewmodel.ListaAnimalViewModel
import com.squareup.picasso.Picasso

class DetalheItemAnimalFragment : Fragment() {

    private lateinit var binding: FragmentDetalheItemAnimalBinding

    private val viewmodel: ListaAnimalViewModel by lazy {
        ViewModelProvider(this)[ListaAnimalViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
      binding = FragmentDetalheItemAnimalBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onResume() {
        super.onResume()
        val animal = pegarAnimal()
        animal?.let {
            exibirItemAnimal(it)
        }
    }
    private fun exibirItemAnimal(animal: AnimalResponseItem){
        animal.apply {
            Picasso.get().load(imageLink).into(binding.ivItemAnimais)
            binding.tvItemTitle.text = latinName
            binding.tvItemTipoDeAnimal.text = animalType
            binding.tvItemTempoAtivo.text = activeTime
            binding.tvComprimentoMin.text = lengthMin
            binding.tvComprimentoMax.text = lengthMax
            binding.tvPesoMin.text = weightMin
            binding.tvPesoMax.text = weightMax
            binding.tvHabitat.text = habitat
            binding.tvDieta.text = diet
            binding.tvVidaUtil.text = lifespan
            binding.tvFaixaGeografia.text = geoRange
        }

    }

//    private fun observe(animal: AnimalResponseItem){
//        viewmodel.animalList.observe(this){
//            animal?.let {
//
//            }
//        }
//    }

    private fun pegarAnimal(): AnimalResponseItem?{
        return arguments?.getParcelable(ANIMAL_KEY)
    }
}