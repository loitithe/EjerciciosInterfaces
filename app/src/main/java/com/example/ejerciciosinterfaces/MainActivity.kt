package com.example.ejerciciosinterfaces

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import com.example.ejerciciosinterfaces.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        initListeners()

    }

    private fun abrirEjemplo1() {
        val intent = Intent(this, Ejemplo1::class.java)
        startActivity(intent)
    }

    private fun abrirPizzeria(){
        val intent = Intent(this, Pizzeria::class.java)
        startActivity(intent)
    }



    private fun initListeners() {
        binding.btnEjemplo1.setOnClickListener {
            abrirEjemplo1()
        }
        binding.btnPizzeria.setOnClickListener { abrirPizzeria() }
    }


}