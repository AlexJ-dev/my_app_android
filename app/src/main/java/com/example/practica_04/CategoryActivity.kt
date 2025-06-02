package com.example.practica_04

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class CategoryActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_5_menu_productos)

        // Obtener número de mesa desde el intent
        val mesaNumero = intent.getIntExtra("mesaNumero", -1)

        // Mostrar número de mesa en un TextView
        val textMesaInfo = findViewById<TextView>(R.id.textMesaInfo)
        textMesaInfo.text = "Mesa seleccionada: $mesaNumero"

        val categories = listOf("All", "Parrillas", "Piqueos", "Alitas", "Fríos", "Calientes", "Pastas", "Jugos", "Cocktails", "Cervezas")

        val categoryRecyclerView = findViewById<RecyclerView>(R.id.categoryRecyclerView)
        val adapter = CategoryAdapter(categories) { selectedCategory ->
            // Aquí puedes manejar la lógica de filtrado según la categoría seleccionada
        }

        categoryRecyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        categoryRecyclerView.adapter = adapter
    }
}