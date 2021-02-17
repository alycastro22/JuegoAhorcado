package hn.edu.ujcv.pdm_proyecto1_i_p1_juegoahorcado


import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_pantalla_juego.*

class PantallaJuego : AppCompatActivity() {
    var palabra = mutableMapOf<String,String>("araña" to "Animal 8 patas", "semana" to "Tiene 7 días", "julio" to "Septimo Mes", "cancion" to "Melodia y ritmo", "araña" to "Animal 8 patas ",
            "carro" to "Vehiculo", "perro" to "Mascota", "rojo" to "Color Pasión", "domingo" to "Día de descanso", "luna" to "satelite natural de la tierra", "año" to "tiene 365 días ")
    private var palabrax = ""
    private var pistax = ""
    private var intentos = 6
    private var partecuerpo = 0
    private var numcorr = 0
    private var numchar = 0
    var correcto = false
    var equivocado =  false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pantalla_juego)
        agregarPalabra()
        mostrarpista(palabra)
        btnValidar.setOnClickListener{Validar(palabra)}
       // muñeco()

    }

    fun agregarPalabra(){
        val bundle = intent.extras
        val palabraN = bundle?.get("Palabra")
        val pistaN = bundle?.get("pista")
        palabra.put(palabraN.toString(), pistaN.toString())

        palabrax = palabra.keys.random()
        pistax = palabra.getValue(palabrax)

    }


     fun mostrarpista(mutableMap: MutableMap<String, String>){
         palabrax = palabra.keys.random()
         pistax = palabra.getValue(palabrax)

        txtPista.text = getString(R.string.Pista1, pistax)

    }


    fun Validar(mutableMap: MutableMap<String, String>) {

        numchar = palabrax.length

        /*for (palabraChar in palabrax){
            val palabraChar : CharArray = palabrax.toCharArray()
            println(palabraChar[0])

        }*/
        for (letra in palabrax){
            var letrausaruio = txtpalabra.text.last()
            if (letra.equals(letrausaruio)){
                correcto = true
                txtvMostrarPalabra.setText(letra.toString())
                numcorr++
            }else{
                equivocado = true
            }

        }

        if (correcto) {
            if (numcorr == numchar) {
                val ganar = Intent(this, PantallaGanaste::class.java)
                startActivity(ganar)
                //partecuerpo--
                limpiar()
            }
        }else if(equivocado){
            partecuerpo++
            println(partecuerpo)
        }
        muñeco()
    }


    fun muñeco(){
        if (partecuerpo<=intentos) {
            if (partecuerpo == 1) {
                imageCabeza.visibility = View.VISIBLE

            }
            if (partecuerpo == 2) {
                imageCabeza.visibility = View.VISIBLE
                imageCuerpo.visibility = View.VISIBLE

            }
            if (partecuerpo == 3) {
                imageCabeza.visibility = View.VISIBLE
                imageCuerpo.visibility = View.VISIBLE
                imageBrazoDerecho.visibility = View.VISIBLE

            }
            if (partecuerpo == 4) {
                imageCabeza.visibility = View.VISIBLE
                imageCuerpo.visibility = View.VISIBLE
                imageBrazoDerecho.visibility = View.VISIBLE
                imageBrazoIzquierdo.visibility = View.VISIBLE

            }
            if (partecuerpo == 5) {
                imageCabeza.visibility = View.VISIBLE
                imageCuerpo.visibility = View.VISIBLE
                imageBrazoDerecho.visibility = View.VISIBLE
                imageBrazoIzquierdo.visibility = View.VISIBLE
                imagePiernaDerecha.visibility = View.VISIBLE

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



