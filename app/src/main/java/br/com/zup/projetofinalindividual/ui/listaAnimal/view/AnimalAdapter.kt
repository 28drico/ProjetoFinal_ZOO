package br.com.zup.projetofinalindividual.ui.listaAnimal.view

import android.graphics.ImageFormat.JPEG
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.zup.projetofinalindividual.URL_BASE_IMG
import br.com.zup.projetofinalindividual.data.model.AnimalResult
import br.com.zup.projetofinalindividual.databinding.ListaAnimalItemBinding
import com.squareup.picasso.Picasso

class AnimalAdapter(
    private var animalList: MutableList<AnimalResult>,
    private val clickAnimal: (animal: AnimalResult) -> Unit,
): RecyclerView.Adapter<AnimalAdapter.ViewHolder>() {


    class ViewHolder(val binding: ListaAnimalItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun showPersonagem(animalResult: AnimalResult) {
            Picasso.get().load(URL_BASE_IMG + animalResult.id + JPEG)
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
        holder.showPersonagem(animal)
        holder.binding.cvListaAnimal.setOnClickListener{
            clickAnimal(animal)
        }
    }

    override fun getItemCount(): Int = animalList.size

    fun updateAnimalList(atualizaLista: MutableList<AnimalResult>){
        animalList = atualizaLista
        notifyDataSetChanged()
    }
}