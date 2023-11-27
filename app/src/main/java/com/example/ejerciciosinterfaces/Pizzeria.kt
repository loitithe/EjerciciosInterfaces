package com.example.ejerciciosinterfaces

import Articulo
import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.ejerciciosinterfaces.adapter.PizzeriaAdapter
import com.example.ejerciciosinterfaces.databinding.ActivityPizzeriaBinding

class Pizzeria : AppCompatActivity() {
    private lateinit var binding: ActivityPizzeriaBinding

    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPizzeriaBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        var intentOpciones = Intent(this, Lista_opciones::class.java)

        binding.btnSalir.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            Toast.makeText(this, "btnSalir", Toast.LENGTH_SHORT).show()
        }

        binding.btnPizzas.setOnClickListener {
        intentOpciones= Intent(this,ListaCheckBox::class.java)
         //   intentOpciones.putExtra("opcionPizzas", 1)
            startActivity(intentOpciones)
        }

        binding.btnBebidas.setOnClickListener {
            intentOpciones.putExtra("opcionPizzas", 2)
            startActivity(intentOpciones)
        }

        binding.btnComplementos.setOnClickListener {
            intentOpciones.putExtra("opcionPizzas", 3)
            startActivity(intentOpciones)
        }

    }

}