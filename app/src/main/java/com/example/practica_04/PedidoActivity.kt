package com.example.practica_04

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.practica_04.databinding.Activity6PedidoBinding
import com.google.android.material.bottomnavigation.BottomNavigationView


class PedidoActivity : AppCompatActivity() {

    private lateinit var pedidoAdapter: PedidoAdapter
    private lateinit var binding: Activity6PedidoBinding
    private lateinit var comidasAdapter: PedidoAdapter
    private lateinit var bebidasAdapter: PedidoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = Activity6PedidoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val btnBack = findViewById<ImageButton>(R.id.btnBack)
        btnBack.setOnClickListener {
            onBackPressed()
        }

        val textPedido =  findViewById<View>(R.id.textPedido)
        textPedido?.findViewById<TextView>(R.id.texto)?.text="N°003211"

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
            Pedido("Parrilla de Pollo", "Sin ensalada", 1, "Comidas"),
            Pedido("Parrilla de Cerdo", "Bien cocido", 2, "Comidas"),
            Pedido("Tequeños de queso", "Normal", 1, "Comidas"),
            Pedido("Salchipapa Especial", "Normal", 1, "Comidas"),
            Pedido("Jarra de Maracuya", "Helada", 1, "Bebidas"),
            Pedido("Mojito Clasico", "Poco alcohol", 4, "Bebidas")
        )
        val comidas = pedidosList.filter { it.categoria == "Comidas" }.toMutableList()
        val bebidas = pedidosList.filter { it.categoria == "Bebidas" }.toMutableList()




        // Configurar adaptadores
        comidasAdapter = PedidoAdapter(comidas)
        bebidasAdapter = PedidoAdapter(bebidas)

        // Aquí agregamos la configuración de los RecyclerView
        findViewById<RecyclerView>(R.id.recyclerComidas).apply {
            layoutManager = GridLayoutManager(this@PedidoActivity, 2) // 2 columnas
            adapter = comidasAdapter
        }

        findViewById<RecyclerView>(R.id.recyclerBebidas).apply {
            layoutManager = GridLayoutManager(this@PedidoActivity, 2) // 2 columnas
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

        findViewById<RecyclerView>(R.id.recyclerComidas).apply {
            layoutManager = LinearLayoutManager(this@PedidoActivity, LinearLayoutManager.VERTICAL, false)
            adapter = comidasAdapter
        }

        findViewById<RecyclerView>(R.id.recyclerBebidas).apply {
            layoutManager = LinearLayoutManager(this@PedidoActivity, LinearLayoutManager.VERTICAL, false)
            adapter = bebidasAdapter
        }
        val bottomNav = findViewById<BottomNavigationView>(R.id.bottomNav)

        bottomNav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> {
                    startActivity(Intent(this, MesasActivity::class.java))
                    true
                }
                R.id.nav_menu -> {
                    startActivity(Intent(this, CategoryActivity::class.java))
                    true
                }
                R.id.nav_user -> {
                    startActivity(Intent(this, UserActivity::class.java))
                    true
                }
                else -> false
            }
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

