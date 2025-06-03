package com.example.practica_04

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.practica_04.databinding.ItemMensajeBinding

class MensajesAdapter(private val mensajes: List<Mensaje>) : RecyclerView.Adapter<MensajesAdapter.ViewHolder>() {

    inner class ViewHolder(private val binding: ItemMensajeBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(mensaje: Mensaje) {
            binding.textMensaje.text = "${mensaje.emoji} ${mensaje.texto}"
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemMensajeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(mensajes[position])
    }

    override fun getItemCount(): Int = mensajes.size
}
