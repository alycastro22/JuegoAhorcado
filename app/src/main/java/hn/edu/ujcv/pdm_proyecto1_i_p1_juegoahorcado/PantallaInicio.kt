package hn.edu.ujcv.pdm_proyecto1_i_p1_juegoahorcado

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_pantalla_adivinar.*

class PantallaInicio : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_principal)


    }

    fun jugar(view: View) {
        val cambiarPantalla = Intent(this, PantallaJuego::class.java)
        startActivity(cambiarPantalla)

    }
    fun palabra(view: View) {
        val cambiarPantalla = Intent(this, PantallaAdivinar::class.java)
        startActivity(cambiarPantalla)

    }



}