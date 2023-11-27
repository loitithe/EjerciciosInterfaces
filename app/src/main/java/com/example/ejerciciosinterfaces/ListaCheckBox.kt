package com.example.ejerciciosinterfaces

import Articulo
import Pedido
import TipoArticulo.Pizzas
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.ejerciciosinterfaces.databinding.ActivityListaCheckBoxBinding


class ListaCheckBox : AppCompatActivity() {

    private lateinit var binding: ActivityListaCheckBoxBinding
    private var articulos: MutableList<Articulo> = mutableListOf()

    lateinit var buttonPlus: Button
    lateinit var buttonDecrease: Button
    lateinit var pizzaS: Pizzas
    lateinit var cajaCantidad: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListaCheckBoxBinding.inflate(layoutInflater)

        setContentView(binding.root)
        init()


    }

    fun init() {
        val lista = Pizzas.values()
        Log.i("checkbox", "tamaño " + lista.size.toString())



    }

    fun plusCantidad() {

    }

    fun decreaseCantidad() {

    }

    fun initComponents() {
        binding.buttonPedido.setOnClickListener {
            val pedido = Pedido(articulos)
        }

    }


}