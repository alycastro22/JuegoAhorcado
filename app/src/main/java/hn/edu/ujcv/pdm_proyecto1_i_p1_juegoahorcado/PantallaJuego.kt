package hn.edu.ujcv.pdm_proyecto1_i_p1_juegoahorcado

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_pantalla_juego.*
import java.util.*
import kotlin.collections.ArrayList

class PantallaJuego : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pantalla_juego)
        agregarpalabra()
    }
     abstract class Ramdon

    fun mostrarpista(){

    }

    fun agregarpalabra( ){
       var mymap: Map<String, String> = mapOf()

        val bundle = intent.extras
        //val palabra = bundle?.get("palabra")
        //val pista= bundle?.get("Pista")
        mymap= mutableMapOf()

        mymap.put("Harry stiles", "Watermelor Sugar High")
        mymap.put("Lana", "Tiene un cono")

        mymap.put(bundle?.get("palabra").toString(), bundle?.get("Pista").toString())



       val pistax=mymap.values.random()
        txtPista.text = getString(R.string.Pista1, pistax)

        println(mymap)

        /*val bundle = intent.extras
        val palabra = bundle?.get("palabra")
        val pista= bundle?.get("Pista")

        val palabras = arrayListOf<String>()
        val pistas = arrayListOf<String>()

        palabras.add(palabra.toString())
        pistas.add(pista.toString())

        println( palabras)
        println*/

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

