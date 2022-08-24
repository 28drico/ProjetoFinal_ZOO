package br.com.zup.projetofinalindividual.ui.splash.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.zup.projetofinalindividual.R
import br.com.zup.projetofinalindividual.ui.home.view.HomeActivity
import br.com.zup.projetofinalindividual.ui.splash.viewmodel.SplashViewmodel

class Splash : AppCompatActivity() {

    private val viewmodel by lazy { SplashViewmodel() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        setupObservable()
        shouldGoToHome()
    }

    private fun setupObservable(){
        viewmodel.goToHome.observe(
            this,
            androidx.lifecycle.Observer{
                startActivity(Intent(this,HomeActivity::class.java))
                finish()
            }
        )
    }

    private fun shouldGoToHome(){
        viewmodel.goToHome()
    }
}