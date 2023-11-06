package com.example.ejerciciosinterfaces

import Articulo
import TipoArticulo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ejerciciosinterfaces.adapter.PizzeriaAdapter

class Lista_opciones : AppCompatActivity() {
    private var opcionElegida :Int = 0
    private var listaRecyclerView: List<Articulo> = emptyList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_opciones)
        val opcion = intent.getIntExtra("opcionPizzas", 0)
        initList(opcion)
        initRecyclerView()
    }

    private fun initRecyclerView() {
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerArticulos)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = PizzeriaAdapter(listaRecyclerView)
    }

    private fun initList(opcion: Int) {
        listaRecyclerView = when (opcion) {
            1 -> TipoArticulo.Pizzas.values().map {
                Articulo(it, cantidad = 1, ingredienteExtra = null)
            }

            2 -> TipoArticulo.Bebidas.values().map {
                Articulo(it, cantidad = null, ingredienteExtra = null)
            }

            3 -> TipoArticulo.Entrantes.values().map {
                Articulo(it, cantidad = null, ingredienteExtra = null)
            }

            else -> emptyList() // En caso de un valor no reconocido
        }
    }

}