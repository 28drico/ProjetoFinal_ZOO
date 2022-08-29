package br.com.zup.projetofinalindividual.ui.listaFavorito.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.zup.projetofinalindividual.data.model.AnimalResponseItem
import br.com.zup.projetofinalindividual.databinding.ListaAnimalItemBinding
import com.squareup.picasso.Picasso

class ListaFavoritoAdapter (
    private var animalList: MutableList<AnimalResponseItem>,
            private val clickAnimal:(animal: AnimalResponseItem) -> Unit
): RecyclerView.Adapter<ListaFavoritoAdapter.ViewHolder>() {

    class ViewHolder(val binding: ListaAnimalItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun showAnimal(animal: AnimalResponseItem) {
            Picasso.get().load(animal.imageLink)
                .into(binding.ivItemImage)
            binding.tvTipoAnimal.text = animal.name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ListaAnimalItemBinding.inflate(LayoutInflater.from(parent.context))
        return ViewHolder(binding)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       val animal = animalList[position]
        holder.showAnimal(animal)
        holder.binding.cvListaAnimal.setOnClickListener{
            clickAnimal(animal)
            updateFavoritoList(animalList)
        }
    }

    fun updateFavoritoList(novoList: MutableList<AnimalResponseItem>){
        animalList = novoList
        notifyDataSetChanged()
    }

    override fun getItemCount() = animalList.size

}