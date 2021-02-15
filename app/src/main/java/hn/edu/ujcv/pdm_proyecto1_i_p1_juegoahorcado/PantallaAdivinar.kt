package hn.edu.ujcv.pdm_proyecto1_i_p1_juegoahorcado


import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_pantalla_adivinar.*
import java.util.*
import kotlin.collections.ArrayList


class PantallaAdivinar: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pantalla_adivinar)
        btnAgregar.setOnClickListener { guardarpalabra() }
    }

    fun guardarpalabra() {
        val listpista = ArrayList<String>()
        listpista.add(idTxtPista.text.toString())
        println(listpista)

        val listapalabra = ArrayList<String>()
        listapalabra.add(idTxtPalabra.text.toString())
        println(listapalabra)

        val i = Intent(this, PantallaJuego::class.java)
        i.putStringArrayListExtra("Lista", listpista)
        i.putStringArrayListExtra("listapa", listapalabra)
        startActivity(i)

    }

}
