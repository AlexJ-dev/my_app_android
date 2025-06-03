package com.example.practica_04

import android.app.AlertDialog
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.practica_04.databinding.ItemPedidoBinding

class PedidoAdapter(private val pedidos: List<Pedido>) : RecyclerView.Adapter<PedidoAdapter.ViewHolder>() {

    inner class ViewHolder(private val binding: ItemPedidoBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(pedido: Pedido) {
            binding.textNombre.text = pedido.nombre
            binding.textEspecificacion.text = pedido.especificacion
            binding.textCantidad.text = "Cantidad: ${pedido.cantidad}"

            binding.btnEliminar.setOnClickListener { showModal(binding.root.context, "¿Está seguro de eliminar el pedido?", "Eliminar") }
            binding.btnEnviar.setOnClickListener { showModal(binding.root.context, "¿Está seguro de enviar este pedido?", "Enviar") }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemPedidoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(pedidos[position])
    }

    override fun getItemCount(): Int = pedidos.size

    private fun showModal(context: Context, mensaje: String, accion: String) {
        val dialogBuilder = AlertDialog.Builder(context)
        dialogBuilder.setMessage(mensaje)
            .setPositiveButton(accion) { dialog, _ ->
                showConfirmationModal(context, "$accion correctamente")
                dialog.dismiss()
            }
            .setNegativeButton("Cancelar") { dialog, _ -> dialog.dismiss() }

        val dialog = dialogBuilder.create()
        dialog.show()
    }

    private fun showConfirmationModal(context: Context, mensaje: String) {
        val dialogBuilder = AlertDialog.Builder(context)
        dialogBuilder.setMessage(mensaje)
            .setPositiveButton("OK") { dialog, _ -> dialog.dismiss() }

        val dialog = dialogBuilder.create()
        dialog.show()
    }
}
