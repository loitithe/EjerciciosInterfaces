package com.example.ejerciciosinterfaces

import Articulo
import Pedido
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.widget.CheckBox
import android.widget.ImageButton
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import com.example.ejerciciosinterfaces.databinding.ActivityListaCheckBoxBinding


class ListaCheckBox : AppCompatActivity() {

    private lateinit var binding: ActivityListaCheckBoxBinding
    private var articulos: MutableList<Articulo> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListaCheckBoxBinding.inflate(layoutInflater)

        setContentView(binding.root)
        init()


    }

    fun init() {
        val lista = Pizzas.values()
        Log.i("checkbox", "tamaño " + lista.size.toString())

        val pizzas_layout = binding.linearVertical
        for (pizza in Pizzas.values()) {
            val cardView = CardView(this)
            val linearLayout = LinearLayout(this)
            linearLayout.orientation = LinearLayout.HORIZONTAL
            linearLayout.background=getDrawable(R.color.dark_blue)
            val checkBox = CheckBox(this)
            checkBox.text = pizza.nombre
            checkBox.textAlignment = CheckBox.TEXT_ALIGNMENT_CENTER
            checkBox.layoutParams = LinearLayout.LayoutParams(
                400,
                LinearLayout.LayoutParams.MATCH_PARENT
            )
            checkBox.background = getDrawable(R.color.dark_blue)
            checkBox.setTextColor(getColor(R.color.white))

            val textViewPrecio = TextView(this)
            textViewPrecio.text = pizza.precio.toString()
            textViewPrecio.setTextColor(Color.WHITE)
            textViewPrecio.layoutParams = LinearLayout.LayoutParams(
                0,
                LinearLayout.LayoutParams.WRAP_CONTENT,
                1f
            )

            val deleteButton = ImageButton(this)
            deleteButton.setOnClickListener{
                actualizaTextViewCantidad(-1)
            }
            deleteButton.setImageResource(android.R.drawable.ic_delete)
            deleteButton.layoutParams = LinearLayout.LayoutParams(
                0,
                LinearLayout.LayoutParams.WRAP_CONTENT,
                1f
            )

            val cantidadTextView = TextView(this)

            cantidadTextView.text = "0"
            cantidadTextView.setTextColor(Color.WHITE)
            cantidadTextView.gravity = Gravity.CENTER
            cantidadTextView.layoutParams = LinearLayout.LayoutParams(
                0,
                LinearLayout.LayoutParams.MATCH_PARENT,
                1f
            )

            cantidadTextView.gravity = TextView.TEXT_ALIGNMENT_CENTER
            cantidadTextView.textSize = 22f

            val addButton = ImageButton(this)
            addButton.setImageResource(android.R.drawable.ic_input_add)
            addButton.layoutParams = LinearLayout.LayoutParams(
                0,
                LinearLayout.LayoutParams.WRAP_CONTENT,
                1f
            )
            addButton.setOnClickListener {
                actualizaTextViewCantidad(+1)
            }

            linearLayout.addView(checkBox)
            linearLayout.addView(textViewPrecio)
            linearLayout.addView(deleteButton)
            linearLayout.addView(cantidadTextView)
            linearLayout.addView(addButton)

            cardView.addView(linearLayout)

            pizzas_layout.addView(cardView)

    }

    fun initComponents() {
        binding.buttonPedido.setOnClickListener {
            val pedido = Pedido(articulos)
        }

    }


}

    private fun actualizaTextViewCantidad(i: Int) {

    }

    public enum class Pizzas(val nombre:String,val precio: Float) {
        QuesoPepperoni("QuesoPepperoni",13.5f),
        Margarita("Margarita",10.2f),
        Hawaiana("Hawaiana",13.5f),
        Pollo("Pollo",15.1f),
        Napolitana("Napolitana",18f),
        QuatroQuesos("QuatroQuesos",17f),
        SalmónAhuQuesoCrema("SalmónAhuQuesoCrema",20f),
        Carbonara("Carbonara",15f),
        Barbacoa("Barbacoa",15.5f),
        Calzone("Calzone",19f);

    }
}