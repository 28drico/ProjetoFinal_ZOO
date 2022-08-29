package br.com.zup.projetofinalindividual.ui.listaAnimal.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.zup.projetofinalindividual.data.model.AnimalResponseItem
import br.com.zup.projetofinalindividual.databinding.ListaAnimalItemBinding
import com.squareup.picasso.Picasso

class AnimalAdapter(
    private var animalList: MutableList<AnimalResponseItem>,
    private val clickAnimal: (animal: AnimalResponseItem) -> Unit,
): RecyclerView.Adapter<AnimalAdapter.ViewHolder>() {


    class ViewHolder(val binding: ListaAnimalItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun showAnimal(animalResult:AnimalResponseItem) {
            Picasso.get().load(animalResult.imageLink)
                .into(binding.ivItemImage)
            binding.tvTipoAnimal.text = animalResult.name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ListaAnimalItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val animal = animalList[position]
        holder.showAnimal(animal)
        holder.binding.cvListaAnimal.setOnClickListener{
            clickAnimal(animal)
        }
    }

    override fun getItemCount(): Int = animalList.size

    fun updateAnimalList(atualizaLista: MutableList<AnimalResponseItem>){
        animalList = atualizaLista
        notifyDataSetChanged()
    }
}