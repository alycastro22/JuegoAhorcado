package hn.edu.ujcv.pdm_proyecto1_i_p1_juegoahorcado

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_pantalla_juego.*

class PantallaJuego : AppCompatActivity() {

    //private val charView = Array<TextView>(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pantalla_juego)
        mostrarpista()
    }


    fun mostrarpista(){

        val lista : ArrayList<String>? = intent.getStringArrayListExtra("Lista")
        val pista = ArrayList<String>()
        pista.add("Animal de 8 patas")
        pista.add("Tiene 7 días")
        pista.add("Septimo Mes")
        pista.add("Tiene melodía y ritmo")

        val palabras = ArrayList<String>()
        palabras.add("ARAÑA")
        palabras.add("SEMANA")
        palabras.add("JULIO")
        palabras.add("CANCION")

        val palabra = mutableMapOf<String,String>("Araña" to "Animal 8 patas", "Semana" to "Tiene 7 días", "Julio" to "Septimo Mes", "Cancion" to "Melodia y ritmo")
        palabra.put("Animal 8 patas","Araña")


        val palabrax = palabra.keys.random()
        val pistax= palabra.getValue(palabrax)
        val pistaxx= palabras.random()
        val palabrajuego=palabrax
        txtPista.text = getString(R.string.Pista1, pistax)

       val charView= Array<TextView>(palabrax.length)

        for ( i in palabrax)
            charView[i.toInt()]= TextView(this )
            charView.


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


