package hn.edu.ujcv.pdm_proyecto1_i_p1_juegoahorcado

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_pantalla_juego.*
import java.util.regex.Matcher
import java.util.regex.Pattern

class PantallaJuego : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pantalla_juego)
        mostrarpista()
    }


    fun mostrarpista(){
        val lista : ArrayList<String>? = intent.getStringArrayListExtra("Lista")
        val pista = ArrayList<String>()
        var intentos = 6
        var partecuerpo = 0
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
        txtPista.text = getString(R.string.Pista1, pistax)

        var parte = ArrayList<ImageView>(6)
        parte = arrayListOf(findViewById<ImageView>(R.id.imageCabeza))
        parte = arrayListOf(findViewById(R.id.imageCuerpo))
        parte = arrayListOf(findViewById(R.id.imageBrazoDerecho))
        parte = arrayListOf(findViewById(R.id.imageBrazoIzquierdo))
        parte = arrayListOf(findViewById(R.id.imagePiernaDerecha))
        parte = arrayListOf(findViewById(R.id.imagePiernaIzquierda))

        for ( i in palabrax) {
            if(txtpalabra.text.equals(palabrax)){
                val ganar = Intent(this, PantallaGanaste::class.java)
                startActivity(ganar)
            }else if (partecuerpo < intentos){
                parte[intentos].visibility
                intentos++
                val perder = Intent(this, PantallaPerdedor::class.java)
                startActivity(perder)
            }
        }
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



