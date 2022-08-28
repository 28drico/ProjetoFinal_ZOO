package br.com.zup.projetofinalindividual.data.datasource.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import br.com.zup.projetofinalindividual.data.model.AnimalResponseItem

@Dao
interface AnimalDao {

    @Query("SELECT * FROM animals")
    fun getAllAnimal(): List<AnimalResponseItem>

    @Insert(onConflict = OnConflictStrategy.REPLACE )
    fun insertAllAnimais(animaisList: List<AnimalResponseItem>)
}