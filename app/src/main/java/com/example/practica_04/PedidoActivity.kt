package com.example.practica_04

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.practica_04.databinding.Activity6PedidoBinding


class PedidoActivity : AppCompatActivity() {

    private lateinit var pedidoAdapter: PedidoAdapter
    private lateinit var binding: Activity6PedidoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = Activity6PedidoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val pedidosList = listOf(
            Pedido("Bife de chorizo", "Sin ensalada", 1, "Comidas"),
            Pedido("Parrilla de pollo", "Bien cocido", 2, "Comidas"),
            Pedido("Jugo de maracuyá", "Sin azúcar", 1, "Bebidas"),
            Pedido("Margarita", "Poco alcohol", 1, "Bebidas")
        )

        pedidoAdapter = PedidoAdapter(pedidosList)
        binding.recyclerPedidos.layoutManager = LinearLayoutManager(this)
        binding.recyclerPedidos.adapter = pedidoAdapter
    }
}
