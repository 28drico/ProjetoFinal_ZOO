package br.com.zup.projetofinalindividual.data.datasource.local.dao

import androidx.room.*
import br.com.zup.projetofinalindividual.data.model.AnimalResponseItem
import br.com.zup.projetofinalindividual.data.model.AnimalResult

@Dao
interface AnimalDao {

    @Query("SELECT * FROM animals")
    fun getAllAnimal(): List<AnimalResponseItem>

    @Insert(onConflict = OnConflictStrategy.REPLACE )
    fun insertAllAnimais(animaisList: List<AnimalResponseItem>)
}