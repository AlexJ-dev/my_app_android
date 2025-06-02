package com.example.practica_04

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

data class Mesa(val numero: Int, val mozo: String, val estado: String)

class MesasAdapter(private val mesas: List<Mesa>) : RecyclerView.Adapter<MesasAdapter.MesaViewHolder>() {

    inner class MesaViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textMesa: TextView = view.findViewById(R.id.textMesa)
        val textMozo: TextView = view.findViewById(R.id.textMozo)
        val textEstado: TextView = view.findViewById(R.id.textEstado)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MesaViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.componente_mesa, parent, false)
        return MesaViewHolder(view)
    }

    override fun onBindViewHolder(holder: MesaViewHolder, position: Int) {
        val mesa = mesas[position]
        holder.textMesa.text = "Mesa ${mesa.numero}"
        holder.textMozo.text = "Mozo: ${mesa.mozo}"
        holder.textEstado.text = "Estado: ${mesa.estado}"
        holder.textEstado.setTextColor(if (mesa.estado == "Ocupada") Color.parseColor("#FF5722") else Color.parseColor("#4CAF50"))
    }

    override fun getItemCount(): Int = mesas.size
}