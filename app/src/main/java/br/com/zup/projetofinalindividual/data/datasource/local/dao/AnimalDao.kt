package br.com.zup.projetofinalindividual.data.datasource.local.dao

import androidx.room.*
import br.com.zup.projetofinalindividual.data.model.AnimalResult

@Dao
interface AnimalDao {

    @Query("SELECT * FROM item")
    fun getAllAnimal(): List<AnimalResult>

    @Insert(onConflict = OnConflictStrategy.REPLACE )
    fun insertAllAnimais(animaisList: List<AnimalResult>)

//    @Query("SELECT * FROM characters WHERE isFavorite = 1")
//    fun getAllFavoritoPersonagem(): List<PersonagensResult>

//    @Update(onConflict = OnConflictStrategy.REPLACE)
//    fun updateFavoritoPersonagens(personagensResult: PersonagensResult)

    @Query("Select * From item")
    fun getCartList(): List<AnimalResult>

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun updateCartList(item: AnimalResult)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertIntoCart(item: AnimalResult)
}