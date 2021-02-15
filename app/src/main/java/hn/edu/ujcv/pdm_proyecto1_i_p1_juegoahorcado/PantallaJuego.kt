package hn.edu.ujcv.pdm_proyecto1_i_p1_juegoahorcado

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import kotlinx.android.synthetic.main.activity_pantalla_juego.*
import java.util.regex.Matcher
import java.util.regex.Pattern

class PantallaJuego : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pantalla_juego)
        mostrarpista(palabra)
        btnValidar.setOnClickListener{Validar(palabra)}
        agregarPalabra()


    }
    private var palabra = mutableMapOf<String,String>("araña" to "Animal 8 patas", "semana" to "Tiene 7 días", "julio" to "Septimo Mes", "cancion" to "Melodia y ritmo", "araña" to "Animal 8 patas ",
    "carro" to "Vehiculo", "perro" to "Mascota", "rojo" to "Color Pasión", "domingo" to "Día de descanso", "luna" to "satelite natural de la tierra", "año" to "tiene 365 días ")
    private val palabrax = palabra.keys.random()
    private val pistax= palabra.getValue(palabrax)
    private var intentos = 6
    private var partecuerpo = 0


    fun agregarPalabra(){
        val bundle = intent.extras
        val palabraN = bundle?.get("Palabra")
        val pistaN = bundle?.get("pista")
        palabra.put(palabraN.toString(), pistaN.toString())
    }



     fun mostrarpista(mutableMap: MutableMap<String, String>){
         val lista : ArrayList<String>? = intent.getStringArrayListExtra("Lista")
         val listaPalabra : ArrayList<String>? = intent.getStringArrayListExtra("listapa")

         val pista = ArrayList<String>()
         pista.add("Animal de 8 patas")
         pista.add("Tiene 7 días")
         pista.add("Septimo Mes")
         pista.add("Tiene melodía y ritmo")
         pista.add("Vehiculo")
         pista.add("Mascota")
         pista.add(lista.toString())

         val palabras = ArrayList<String>()
         palabras.add("Araña")
         palabras.add("Semana")
         palabras.add("Julio")
         palabras.add("Cancion")
         palabras.add("Carro")
         palabras.add("Perro")
         palabras.add(listaPalabra.toString())

         /*val bundle = intent.extras
         val palabraN = bundle?.get("Palabra")
         val pistaN = bundle?.get("pista")
         palabra.put(palabraN.toString(), pistaN.toString())*/

        txtPista.text = getString(R.string.Pista1, pistax)

    }


    fun Validar(mutableMap: MutableMap<String, String>) {


        if (txtpalabra.text.toString().equals(palabrax)) {
            val ganar = Intent(this, PantallaGanaste::class.java)
            startActivity(ganar)
            partecuerpo--
            limpiar()
        }
        if (partecuerpo<intentos){
            partecuerpo++

            if (partecuerpo == 1) {
                imageCabeza.visibility = View.VISIBLE
                limpiar()
            }
            if (partecuerpo == 2) {
                imageCabeza.visibility = View.VISIBLE
                imageCuerpo.visibility = View.VISIBLE
                limpiar()
            }
            if (partecuerpo == 3) {
                imageCabeza.visibility = View.VISIBLE
                imageCuerpo.visibility = View.VISIBLE
                imageBrazoDerecho.visibility = View.VISIBLE
                limpiar()
            }
            if (partecuerpo == 4) {
                imageCabeza.visibility = View.VISIBLE
                imageCuerpo.visibility = View.VISIBLE
                imageBrazoDerecho.visibility = View.VISIBLE
                imageBrazoIzquierdo.visibility = View.VISIBLE
                limpiar()
            }
            if (partecuerpo == 5) {
                imageCabeza.visibility = View.VISIBLE
                imageCuerpo.visibility = View.VISIBLE
                imageBrazoDerecho.visibility = View.VISIBLE
                imageBrazoIzquierdo.visibility = View.VISIBLE
                imagePiernaDerecha.visibility = View.VISIBLE
                limpiar()
            }
            if (partecuerpo == 6) {
                imageCabeza.visibility = View.VISIBLE
                imageCuerpo.visibility = View.VISIBLE
                imageBrazoDerecho.visibility = View.VISIBLE
                imageBrazoIzquierdo.visibility = View.VISIBLE
                imagePiernaDerecha.visibility = View.VISIBLE
                imagePiernaIzquierda.visibility = View.VISIBLE
                val perder = Intent(this, PantallaPerdedor::class.java)
                startActivity(perder)
                limpiar()
            }
        }

    }
    fun limpiar(){
        txtpalabra.text.clear()
    }




    /* fun validarletra(): Boolean{
             Pattern p = Pattern.compile("^([A-Z])$");
             Matcher m = p.matcher(.getText());


             if(m.find() && m.group().equals(.getText())){
                 return true;
             } else{
                 Alert alert =new Alert(Alert.AlertType.ERROR);
                 alert.setTitle("Validar nombre");
                 alert.setHeaderText(null);
                 alert.setContentText("Verifique la siguiente información: " +
                         " \nDeberá escribir un nombre que contenga:" +
                         " \nPrimera letra mayúscula" +
                         " \nAl menos un apellido" +
                         " \nEste campo solo letras");
                 alert.showAndWait();

                 return false;
             }
         }*/

}



