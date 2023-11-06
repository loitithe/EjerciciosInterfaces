package com.example.ejerciciosinterfaces.adapter

import Articulo
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ejerciciosinterfaces.R

class PizzeriaAdapter(private val listaOpciones: List<Articulo>) :
    RecyclerView.Adapter<PizzeriaViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PizzeriaViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return PizzeriaViewHolder(layoutInflater.inflate(R.layout.item_opcion,parent,false))
    }
    override fun getItemCount(): Int = listaOpciones.size
    override fun onBindViewHolder(holder: PizzeriaViewHolder, position: Int) {
        val item=listaOpciones[position]
        holder.renderArticulo(item)
    }

}