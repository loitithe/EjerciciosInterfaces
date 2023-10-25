package com.example.ejerciciosinterfaces

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import com.example.ejerciciosinterfaces.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var viewBinding : ActivityMainBinding
    lateinit var tvResultado: TextView
    lateinit var tvNum1: TextView
    lateinit var tvNum2: TextView
    lateinit var radioGroup: RadioGroup
    lateinit var radioButtonSumar: RadioButton
    lateinit var radioButtonRestar: RadioButton
    lateinit var btn_Calcular: Button
    lateinit var btn_Pizzeria: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initComponents()
        initListeners()
    }


    private fun initComponents() {
        tvResultado = findViewById(R.id.tvResultado)
        tvNum1 = findViewById(R.id.tvNum1)
        tvNum2 = findViewById(R.id.tvNum2)
        radioGroup = findViewById(R.id.radiogroup)
        radioButtonSumar = findViewById(R.id.radioButtonSumar)
        radioButtonRestar = findViewById(R.id.radioButtonRestar)
        btn_Calcular = findViewById(R.id.btnCalcular)
        btn_Pizzeria = findViewById(R.id.btn_pizzeria)
    }

    private fun initListeners() {
        btn_Calcular.setOnClickListener {
            if (radioButtonRestar.isChecked) {
                restar()
            }
            if (radioButtonSumar.isChecked) {
                sumar()
            }
        }


        btn_Pizzeria.setOnClickListener {
            val it = Intent(this, Pizzeria::class.java)
            startActivity(it)
            //
        }

    }

    private fun sumar() {
        val num1: Int = Integer.parseInt(tvNum1.getText().toString())
        val num2: Int = Integer.parseInt(tvNum2.getText().toString())
        val resultado = num1 + num2
        tvResultado.text = resultado.toString()

    }

    private fun restar() {
        val num1: Int = Integer.parseInt(tvNum1.getText().toString())
        val num2: Int = Integer.parseInt(tvNum2.getText().toString())
        val resultado = num1 - num2
        tvResultado.text = resultado.toString()
    }

    private fun toast() {
        Toast.makeText(this, "Toast!", Toast.LENGTH_SHORT).show()
    }
}