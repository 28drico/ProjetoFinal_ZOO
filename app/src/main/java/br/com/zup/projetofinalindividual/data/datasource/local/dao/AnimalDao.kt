package br.com.zup.projetofinalindividual.data.datasource.local.dao

import androidx.room.*
import br.com.zup.projetofinalindividual.data.model.AnimalResponseItem

@Dao
interface AnimalDao {

    @Query("SELECT * FROM animals")
    fun getAllAnimal(): List<AnimalResponseItem>

    @Insert(onConflict = OnConflictStrategy.REPLACE )
    fun insertAllAnimais(animaisList: List<AnimalResponseItem>)

    @Query("SELECT * FROM animals WHERE isFavorite = 1")
    fun getAllFavoritoAnimal(): List<AnimalResponseItem>

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun updateFavoritoAnimal(animalResponseItem: AnimalResponseItem)
}