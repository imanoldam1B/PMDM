package com.example.calculadoraimc

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val introducePeso: EditText = findViewById(R.id.Peso_kg)
        val introduceAltura: EditText = findViewById(R.id.Altura_m)
        val botonCalculo: Button = findViewById(R.id.BotonCalcular)
        val resultadoCalculo: TextView = findViewById(R.id.Resultado)

        var valorPeso: Int = 0
        var valorAltura: Float = 0F
        var imc: Float = 0F

        botonCalculo.setOnClickListener {
            val textoPeso = introducePeso.text.toString()
            if (textoPeso.isNotEmpty()) {
                valorPeso = textoPeso.toInt()
            } else {
                println("Falta algún valor por rellenar")
            }

            val textoAltura = introduceAltura.text.toString()
            if (textoAltura.isNotEmpty()) {
                valorAltura = textoAltura.toFloat()
            } else {
                println("Falta algún valor por rellenar")
            }

            if (valorPeso != 0 && valorAltura != 0F) {
                imc = valorPeso / (valorAltura * valorAltura)
                resultadoCalculo.text = imc.toString()
                mostrarMensajeSegunIMC(imc)
            }
        }
    }

    private fun mostrarMensajeSegunIMC(imc: Float) {
        val mensajeSalida: TextView = findViewById(R.id.Mensaje)
        val mensaje: String = when {
            imc < 18.5 -> "Usted sufre delgadez, debería comer más."
            imc in 18.5..24.9 -> "Su estado de forma es bueno."
            imc in 25.0..29.9 -> "Usted sufre sobrepeso, debería cuidarse y llamar a un dietista."
            else -> "Usted sufre obesidad, debería llamar a un médico urgentemente."
        }
        mensajeSalida.text = mensaje
    }
}
