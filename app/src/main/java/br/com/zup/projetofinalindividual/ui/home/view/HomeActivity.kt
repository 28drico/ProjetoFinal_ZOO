package br.com.zup.projetofinalindividual.ui.home.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import br.com.zup.projetofinalindividual.R
import br.com.zup.projetofinalindividual.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding
    private lateinit var toolbar: Toolbar
    private val navController : NavController by lazy { findNavController(R.id.nav_host_fragment) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        toolbar = binding.toolbar
        toolbar.title = ""
        setSupportActionBar(toolbar)



      setupActionBarWithNavController(navController)
        binding.bottomNavigationView.setupWithNavController(navController)

        binding.bottomNavigationView.setOnItemSelectedListener {
            when(it.itemId){
                R.id.ListaAnimal -> {
                    navController.navigate(R.id.listaAnimalFragment)
                    true
                }
                R.id.ListaFavorito -> {
                    navController.navigate(R.id.listaFavoritoFragment)
                    true
                }
                else -> false
            }
        }

    }
    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }
}