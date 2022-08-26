package br.com.zup.projetofinalindividual.data.datasource.local

import android.app.Application
import androidx.room.Room
import br.com.zup.projetofinalindividual.data.datasource.local.database.AnimalDatabase

class AppApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        database = Room.databaseBuilder(
            applicationContext,
            AnimalDatabase::class.java, "database-character"
        )
            .fallbackToDestructiveMigration().allowMainThreadQueries()
            .build()

    }

    companion object {
        private lateinit var database: AnimalDatabase
        fun getdatabase(): AnimalDatabase = database
    }
}