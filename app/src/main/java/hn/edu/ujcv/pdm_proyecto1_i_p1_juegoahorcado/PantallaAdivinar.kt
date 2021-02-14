package hn.edu.ujcv.pdm_proyecto1_i_p1_juegoahorcado

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_pantalla_adivinar.*

class PantallaAdivinar : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pantalla_adivinar)
        btnAgregar.setOnClickListener() {
            guardarp()


        }


    }

    fun guardarp(){
        if (idTxtPalabra.text.isNotEmpty() && idTxtPista.text.isNotEmpty()){
            val intent = Intent(this, PantallaJuego::class.java)
            intent.putExtra("palabra", idTxtPalabra.text.toString())
            intent.putExtra("Pista", idTxtPista.text.toString())
            startActivity(intent)

            val parametros = intent.extras
            if (parametros != null) {
                val palabra = parametros.getString("palabra")
                idTxtPalabra.setText(palabra)
                val pista = parametros.getString("Pista")
                idTxtPalabra.setText(pista)
            }

            val cambiarPantalla = Intent(this, PantallaInicio::class.java)
            startActivity(cambiarPantalla)
            println()





            /* var mymap: Map<String, String> = mapOf()

             mymap= mutableMapOf("lana " to  "tieneun cono")

             mymap.put("Harry stiles", "Watermelor Sugar High")

             mymap.put(idTxtPalabra.text.toString(), idTxtPista.text.toString())
             println(mymap)*/


            Toast.makeText(this, "Su palabra ha sido agregada con éxito", Toast.LENGTH_LONG).show()

        }else {
            Toast.makeText(this, "Debe ingresar palabra y pista", Toast.LENGTH_LONG).show()

        }
    }


}