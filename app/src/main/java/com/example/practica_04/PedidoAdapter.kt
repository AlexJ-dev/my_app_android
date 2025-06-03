package com.example.practica_04

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.practica_04.databinding.ItemPedidoBinding

class PedidoAdapter(private val pedidos: MutableList<Pedido>) : RecyclerView.Adapter<PedidoAdapter.ViewHolder>() {

    inner class ViewHolder(private val binding: ItemPedidoBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(pedido: Pedido, position: Int) {
            binding.textNombre.text = pedido.nombre
            binding.textEspecificacion.text = pedido.especificacion
            binding.textCantidad.text = "Cantidad: ${pedido.cantidad}"

            // Eliminar plato directamente al presionar el botón ❌
            binding.btnEliminarPlato.setOnClickListener {
                removePedido(position)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemPedidoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(pedidos[position], position)
    }

    override fun getItemCount(): Int = pedidos.size

    // Método para eliminar un solo pedido
    private fun removePedido(position: Int) {
        pedidos.removeAt(position)
        notifyItemRemoved(position)
        notifyItemRangeChanged(position, pedidos.size)
    }

    // Método para eliminar todos los pedidos
    fun clearPedidos() {
        pedidos.clear()
        notifyDataSetChanged()
    }
}
