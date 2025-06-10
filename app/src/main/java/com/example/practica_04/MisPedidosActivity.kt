package com.example.practica_04

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView

class MisPedidosActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_7_mispedidos)

        // Botón de regresar a MesasActivity
        val btnBack = findViewById<ImageButton>(R.id.btnBack)
        btnBack.setOnClickListener {
            val intent = Intent(this, MesasActivity::class.java)
            startActivity(intent)
            finish()
        }
        val textMisPedidos =  findViewById<View>(R.id.textMisPedidos)
        textMisPedidos?.findViewById<TextView>(R.id.texto)?.text="Mis Pediddos"

        // Lista de pedidos simulada
        val pedidosList = listOf(
            MisPedidos("Nº00001", "Alex", "4:30", "En preparación", "Mesa 01"),
            MisPedidos("Nº00003", "Luis", "6:00", "Servido", "Mesa 03")
        )

        // Configurar RecyclerView
        val pedidoAdapter = MisPedidosAdapter(pedidosList) // Cambiar a MisPedidosAdapter
        findViewById<RecyclerView>(R.id.recyclerPedidos).apply {
            layoutManager = LinearLayoutManager(this@MisPedidosActivity)
            adapter = pedidoAdapter
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
}
