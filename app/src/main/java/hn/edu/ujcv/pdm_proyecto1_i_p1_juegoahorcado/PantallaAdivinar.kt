package hn.edu.ujcv.pdm_proyecto1_i_p1_juegoahorcado


import android.content.Intent
import android.os.Bundle
import android.widget.Toast
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
        if (idTxtPalabra.text.isNotEmpty() && idTxtPista.text.isNotEmpty()) {
            val intent = Intent(this, PantallaJuego::class.java)
            intent.putExtra("Palabra", idTxtPalabra.text.toString())
            intent.putExtra("pista", idTxtPista.text.toString())
            startActivity(intent)
            Toast.makeText(this, "Palabra agregada con éxito", Toast.LENGTH_SHORT).show()
        }else{
            Toast.makeText(this, "Llena los campos", Toast.LENGTH_LONG).show()
        }
    }

}
