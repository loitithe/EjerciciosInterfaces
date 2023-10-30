package com.example.ejerciciosinterfaces

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.ejerciciosinterfaces.databinding.ActivityEjemplo1Binding

class Ejemplo1 : AppCompatActivity() {
    private lateinit var viewBinding: ActivityEjemplo1Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewBinding = ActivityEjemplo1Binding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        initListeners()
    }


    private fun initListeners() {
        viewBinding.btnCalcular.setOnClickListener {
            if (viewBinding.rbRestar.isChecked) {
                restar()
            }
            if (viewBinding.rbSumar.isChecked) {
                sumar()
            }
        }
        viewBinding.btnInicio.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))


        }
    }

    private fun sumar() {
        val num1: Int = Integer.parseInt(viewBinding.num1.getText().toString())
        val num2: Int = Integer.parseInt(viewBinding.num2.getText().toString())
        val resultado = num1 + num2
        viewBinding.tvResultado.text = resultado.toString()

    }

    private fun restar() {
        val num1: Int = Integer.parseInt(viewBinding.num1.getText().toString())
        val num2: Int = Integer.parseInt(viewBinding.num2.getText().toString())
        val resultado = num1 - num2
        viewBinding.tvResultado.text = resultado.toString()
    }

    private fun toast() {
        Toast.makeText(this, "Toast!", Toast.LENGTH_SHORT).show()
    }
}