package com.example.ejerciciosinterfaces.adapter

import Articulo
import TipoArticulo
import android.view.View
import android.view.View.OnClickListener
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.ejerciciosinterfaces.R
import java.text.FieldPosition

class PizzeriaViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val opcion_name = view.findViewById<TextView>(R.id.txtView_OpcionName)
  //  private var clickListener: OnClickListener? = null
    // val opcion_descripcion = view.findViewById<TextView>(R.id.txtView_Descripcion)
    val opcion_precio = view.findViewById<TextView>(R.id.txtView_Precio)
    val opcion_img = view.findViewById<ImageView>(R.id.imgOpcion)

    fun renderArticulo(articuloModel: Articulo) {
        opcion_name.text = articuloModel.nombre
        opcion_precio.text = articuloModel.precio.toString()

    }

    inner class ItemViewHolder(view: View):RecyclerView.ViewHolder(view),View.OnClickListener{
        init {
            view.setOnClickListener(this)
        }

        override fun onClick(v: View?) {

        }
    }
}
