package com.example.practica_04

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.practica_04.databinding.Activity7MispedidosBinding
import com.example.practica_04.databinding.ItemMispedidosBinding


class MisPedidosAdapter(private val pedidos: List<MisPedidos>) : RecyclerView.Adapter<MisPedidosAdapter.ViewHolder>() {

    inner class ViewHolder(private val binding: ItemMispedidosBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(pedido: MisPedidos) {
            binding.textNumeroPedido.text = pedido.numero
            binding.textMozo.text = "Mozo: ${pedido.mozo}"
            binding.textHoraPedido.text = "Hora: ${pedido.hora}"
            binding.textEstado.text = pedido.estado
            binding.textMesa.text = pedido.mesa

            binding.btnVer.setOnClickListener {
                val intent = Intent(binding.root.context, PedidoActivity::class.java)
                binding.root.context.startActivity(intent)
            }
            binding.btnFactura.setOnClickListener {
                val intent = Intent(binding.root.context, FacturaActivity::class.java)
                binding.root.context.startActivity(intent)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemMispedidosBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(pedidos[position])
    }

    override fun getItemCount(): Int = pedidos.size
}


