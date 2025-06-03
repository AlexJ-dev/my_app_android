package com.example.practica_04

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.practica_04.databinding.Activity6PedidoBinding


class PedidoActivity : AppCompatActivity() {

    private lateinit var pedidoAdapter: PedidoAdapter
    private lateinit var binding: Activity6PedidoBinding
    private lateinit var comidasAdapter: PedidoAdapter
    private lateinit var bebidasAdapter: PedidoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = Activity6PedidoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val btnEliminarTodo = findViewById<Button>(R.id.btnEliminarTodo)
        val btnEnviarPedido = findViewById<Button>(R.id.btnEnviarPedido)
        val btnAgregarProductos = findViewById<Button>(R.id.btnAgregarProductos)

        btnEliminarTodo.setOnClickListener {
            pedidoAdapter.clearPedidos()
        }

        btnEnviarPedido.setOnClickListener {
            Toast.makeText(this, "Pedido enviado correctamente", Toast.LENGTH_SHORT).show()
        }

        btnAgregarProductos.setOnClickListener {
            startActivity(Intent(this, CategoryActivity::class.java))
        }

        val pedidosList = mutableListOf(
            Pedido("Bife de chorizo", "Sin ensalada", 1, "Comidas"),
            Pedido("Parrilla de pollo", "Bien cocido", 2, "Comidas"),
            Pedido("Jugo de maracuyá", "Sin azúcar", 1, "Bebidas"),
            Pedido("Margarita", "Poco alcohol", 1, "Bebidas")
        )
        val comidas = pedidosList.filter { it.categoria == "Comidas" }.toMutableList()
        val bebidas = pedidosList.filter { it.categoria == "Bebidas" }.toMutableList()

        // Configurar adaptadores
        comidasAdapter = PedidoAdapter(comidas)
        bebidasAdapter = PedidoAdapter(bebidas)

        findViewById<RecyclerView>(R.id.recyclerComidas).apply {
            layoutManager = LinearLayoutManager(this@PedidoActivity)
            adapter = comidasAdapter
        }

        findViewById<RecyclerView>(R.id.recyclerBebidas).apply {
            layoutManager = LinearLayoutManager(this@PedidoActivity)
            adapter = bebidasAdapter
        }

        // Mostrar datos de mesa, mozo y fecha
        findViewById<TextView>(R.id.textMesaNumero).text = "Mesa #12"
        findViewById<TextView>(R.id.textMozo).text = "Mozo: Juan Pérez"
        findViewById<TextView>(R.id.textFecha).text = "Fecha: ${getCurrentDate()}"

        // Botones generales
        findViewById<Button>(R.id.btnEliminarTodo).setOnClickListener {
            comidasAdapter.clearPedidos()
            bebidasAdapter.clearPedidos()
        }

        findViewById<Button>(R.id.btnEnviarPedido).setOnClickListener {
            Toast.makeText(this, "Pedido enviado correctamente", Toast.LENGTH_SHORT).show()
        }

        findViewById<Button>(R.id.btnAgregarProductos).setOnClickListener {
            startActivity(Intent(this, CategoryActivity::class.java))
        }
    }

    private fun getCurrentDate(): String {
        val sdf = java.text.SimpleDateFormat("dd/MM/yyyy")
        return sdf.format(java.util.Date())
    }


//      pedidoAdapter = PedidoAdapter(pedidosList)
//        binding.recyclerPedidos.layoutManager = LinearLayoutManager(this)
//        binding.recyclerPedidos.adapter = pedidoAdapter

}

