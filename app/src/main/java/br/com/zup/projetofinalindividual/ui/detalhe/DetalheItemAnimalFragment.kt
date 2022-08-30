package br.com.zup.projetofinalindividual.ui.detalhe

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import br.com.zup.projetofinalindividual.ANIMAL_KEY
import br.com.zup.projetofinalindividual.DESFAVORITO
import br.com.zup.projetofinalindividual.FAVORITO_SUCESSO
import br.com.zup.projetofinalindividual.R
import br.com.zup.projetofinalindividual.data.model.AnimalResponseItem
import br.com.zup.projetofinalindividual.databinding.FragmentDetalheItemAnimalBinding
import br.com.zup.projetofinalindividual.ui.listaFavorito.viewmodel.ListaFavoritoViewModel
import com.squareup.picasso.Picasso

class DetalheItemAnimalFragment : Fragment() {

    private lateinit var binding: FragmentDetalheItemAnimalBinding

    private val favoriteviewmodel: ListaFavoritoViewModel by lazy {
        ViewModelProvider(this)[ListaFavoritoViewModel::class.java]
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
            clickFavorito(it)

        }
        observe(animal)
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
            animalStatus(animal)
        }

    }

    private fun clickFavorito(animal : AnimalResponseItem){
        binding.ivFavorito.setOnClickListener {
            animal.isFavorite = !animal.isFavorite
            updateFavorito(animal)
            exibirItemAnimal(animal)

            if (animal.isFavorite){
                Toast.makeText(
                    context,
                    FAVORITO_SUCESSO,
                    Toast.LENGTH_LONG).show()
            }else{
                Toast.makeText(
                    context,
                    DESFAVORITO,
                    Toast.LENGTH_LONG
                ).show()
            }
        }
    }
    private fun updateFavorito(animal: AnimalResponseItem){
        favoriteviewmodel.disfavorito(animal)
    }

    private fun observe(animal: AnimalResponseItem?){
        favoriteviewmodel.animalListFavoritoState .observe(this){
            animal?.let {
                animalStatus(it)
            }
        }
    }

    private fun animalStatus(animal : AnimalResponseItem){
        binding.ivFavorito.setImageDrawable(
            ContextCompat.getDrawable(
                binding.root.context,
                if(animal.isFavorite){
                    R.drawable.icon_favorite
                }else{
                    R.drawable.icon_notfavorite
                }
            )
        )
    }

    private fun pegarAnimal(): AnimalResponseItem?{
        return arguments?.getParcelable(ANIMAL_KEY)
    }
}