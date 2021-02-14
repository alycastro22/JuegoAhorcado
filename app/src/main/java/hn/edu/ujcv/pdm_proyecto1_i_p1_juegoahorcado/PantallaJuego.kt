package hn.edu.ujcv.pdm_proyecto1_i_p1_juegoahorcado

import android.content.Intent
import android.os.Bundle
import android.os.Parcelable
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_pantalla_adivinar.*
import kotlinx.android.synthetic.main.activity_pantalla_juego.*

class PantallaJuego : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pantalla_juego)
        mostrarpista()
    }
    fun mostrarpista(){
        val lista : ArrayList<String>? = intent.getStringArrayListExtra("Lista")

        if (lista != null) {
            txtPista.text = getString(R.string.Pista1, lista.random().toString())
        }
    }

    fun ganar(view: View) {
        val cambiarPantalla = Intent(this, PantallaGanaste::class.java)
        startActivity(cambiarPantalla)
    }

    fun perder(view: View) {
        val cambiarPantalla = Intent(this, PantallaPerdedor::class.java)
        startActivity(cambiarPantalla)
    }

}


