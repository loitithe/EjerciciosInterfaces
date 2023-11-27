package com.example.ejerciciosinterfaces.adapter

import Articulo
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ejerciciosinterfaces.R


class PizzeriaAdapter(private val listaOpciones: List<Articulo>) :
    RecyclerView.Adapter<PizzeriaViewHolder>() {
    private var clickListener: OnClickListener?=null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PizzeriaViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return PizzeriaViewHolder(layoutInflater.inflate(R.layout.item_opcion,parent,false))
    }
    override fun getItemCount(): Int = listaOpciones.size
    override fun onBindViewHolder(holder: PizzeriaViewHolder, position: Int) {
        val item=listaOpciones[position]
        holder.renderArticulo(item)
    }

    fun getItem(position: Int) : Articulo? {
        return  listaOpciones?.get(position)
    }
    fun setOnItemClickListener(clickListener: OnClickListener){
        this.clickListener=clickListener
    }

}
//handle item clicks
interface  RecyclerViewEvent{
    fun onItemClick(position: Int)
}

