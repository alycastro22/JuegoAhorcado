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

    }
    private var palabra = mutableMapOf<String,String>("Araña" to "Animal 8 patas", "Semana" to "Tiene 7 días", "Julio" to "Septimo Mes", "Cancion" to "Melodia y ritmo", "Araña" to "Animal 8 patas ")
    private val palabrax = palabra.keys.random()
    private val pistax= palabra.getValue(palabrax)
    private var intentos = 6
    private var partecuerpo = 0



     fun mostrarpista(mutableMap: MutableMap<String, String>){
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

        //val palabra = mutableMapOf<String,String>("Araña" to "Animal 8 patas", "Semana" to "Tiene 7 días", "Julio" to "Septimo Mes", "Cancion" to "Melodia y ritmo")



        txtPista.text = getString(R.string.Pista1, pistax)


    }


    fun Validar(mutableMap: MutableMap<String, String>) {
        intentos=intentos-1

        do{
            if (intentos == 5) {
                imageCabeza.visibility = View.VISIBLE
            }
            if (intentos == 4) {
                imageCabeza.visibility = View.VISIBLE
                imageCuerpo.visibility = View.VISIBLE
            }
            if (intentos == 3) {
                imageCabeza.visibility = View.VISIBLE
                imageCuerpo.visibility = View.VISIBLE
                imageBrazoDerecho.visibility = View.VISIBLE
            }
            if (intentos == 2) {
                imageCabeza.visibility = View.VISIBLE
                imageCuerpo.visibility = View.VISIBLE
                imageBrazoDerecho.visibility = View.VISIBLE
                imageBrazoIzquierdo.visibility = View.VISIBLE
            }
            if (intentos == 1) {
                imageCabeza.visibility = View.VISIBLE
                imageCuerpo.visibility = View.VISIBLE
                imageBrazoDerecho.visibility = View.VISIBLE
                imageBrazoIzquierdo.visibility = View.VISIBLE
                imagePiernaDerecha.visibility = View.VISIBLE
            }
            if (intentos == 0) {
                imageCabeza.visibility = View.VISIBLE
                imageCuerpo.visibility = View.VISIBLE
                imageBrazoDerecho.visibility = View.VISIBLE
                imageBrazoIzquierdo.visibility = View.VISIBLE
                imagePiernaDerecha.visibility = View.VISIBLE
                imagePiernaIzquierda.visibility = View.VISIBLE
                val perder = Intent(this, PantallaPerdedor::class.java)
                startActivity(perder)
            }

            if (txtpalabra.text.toString().equals(palabrax)) {
                val ganar = Intent(this, PantallaGanaste::class.java)
                startActivity(ganar)
            }
        }while(txtpalabra.text.toString() != palabrax)


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



