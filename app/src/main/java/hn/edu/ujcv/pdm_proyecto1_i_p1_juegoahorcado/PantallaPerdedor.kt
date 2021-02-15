package hn.edu.ujcv.pdm_proyecto1_i_p1_juegoahorcado

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class PantallaPerdedor : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pantalla_perdedor)
    }

    fun salir(view: View) {
        val salirB = Intent(this, PantallaInicio::class.java)
        startActivity(salirB)
    }
    fun jugar(view: View) {
        val jugarN = Intent(this, PantallaJuego::class.java)
        startActivity(jugarN)
    }
}