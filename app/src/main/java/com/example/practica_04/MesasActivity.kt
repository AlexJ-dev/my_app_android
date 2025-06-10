package com.example.practica_04

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView

class MesasActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_3_menu_mesas)

        val textMenuMesa =  findViewById<View>(R.id.textMenuMesas)
        textMenuMesa?.findViewById<TextView>(R.id.texto)?.text="Menu de Mesas"

        val recyclerMesas = findViewById<RecyclerView>(R.id.recyclerMesas)
        recyclerMesas.layoutManager = GridLayoutManager(this, 3)

        // Generar lista de mesas dinámicamente
        val mesasList = List(50) { i ->
            Mesa(i + 1, if (i % 2 == 0) "Ana" else "Juan", if (i % 3 == 0) "Ocupada" else "Disponible")
        }

        recyclerMesas.adapter = MesasAdapter(mesasList) { mesaSeleccionada ->
            val intent = Intent(this, SalaActivity::class.java)
            intent.putExtra("mesaNumero", mesaSeleccionada.numero) // Pasamos el número de la mesa
            startActivity(intent)
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
