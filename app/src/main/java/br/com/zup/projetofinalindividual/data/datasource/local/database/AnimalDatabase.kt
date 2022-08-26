package br.com.zup.projetofinalindividual.data.datasource.local.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import br.com.zup.projetofinalindividual.data.datasource.local.dao.AnimalDao
import br.com.zup.projetofinalindividual.data.model.AnimalResult

@Database(entities = [AnimalResult::class], version = 2)
abstract class AnimalDatabase : RoomDatabase() {
    abstract fun animalDao(): AnimalDao

//    companion object{
//        @Volatile
//        private var INSTANCE: AnimalDatabase? = null
//
//        fun getAnimaisDataBase(context: Context): AnimalDatabase{
//            val tempInstance = INSTANCE
//            if (tempInstance != null){
//                return tempInstance
//            }
//            synchronized(this){
//                val instance = Room.databaseBuilder(
//                    context.applicationContext,
//                    AnimalDatabase::class.java,
//                    "personagem_database"
//                ).fallbackToDestructiveMigration()
//                    .build()
//                INSTANCE = instance
//                return instance
//            }
//        }
  //  }
}