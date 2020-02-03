package com.example.laboratorio3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.annotation.VisibleForTesting
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    //Inicialización de variables
    private lateinit var star: FloatingActionButton
    private lateinit var info: TextView
    private lateinit var inputBut: EditText
    private lateinit var display: TextView
    private lateinit var name: TextView
    private var showing = false
    private lateinit var change: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Se asignan los items a las variables
        star = findViewById(R.id.starBut)
        info = findViewById(R.id.info_display)
        inputBut = findViewById(R.id.input)
        display = findViewById(R.id.display)
        name = findViewById(R.id.textView3)
        change = findViewById(R.id.antiguaBut)

        //Cuando se le de click al boton de la estrella se ocultan algunos items y se muestra el texto escrito
        star.setOnClickListener{
            if(this.showing.not()){
                showing = true
                name.visibility = View.GONE
                display.text = inputBut.text.toString()
                inputBut.visibility=View.GONE
                display.visibility=View.VISIBLE
            }
            else{
                showing = false
                name.visibility = View.VISIBLE
                inputBut.visibility=View.VISIBLE
                display.visibility=View.GONE
            }
        }

        //Cuando se le da click al boton de Antigua se lleva a la segunda actividad
        change.setOnClickListener{
            launchSecondActivity()
        }

    }

    //Funcion para ejecutar la segunda actividad
    fun launchSecondActivity() {
        val intent = Intent(this, Main2Activity::class.java)
        startActivity(intent)
    }

}
