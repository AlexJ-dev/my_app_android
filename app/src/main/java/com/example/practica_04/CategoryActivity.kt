package com.example.practica_04

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.GridLayoutManager
import com.google.android.material.bottomnavigation.BottomNavigationView

class CategoryActivity : AppCompatActivity() {
    private lateinit var dishAdapter: DishAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_5_menu_productos)

        // Obtener número de mesa desde el intent
        //val mesaNumero = intent.getIntExtra("mesaNumero", -1)

        // Mostrar número de mesa en un TextView
        //val textMesaInfo = findViewById<TextView>(R.id.textMesaInfo)
        //textMesaInfo.text = "Mesa seleccionada: $mesaNumero"

        val categories = listOf("All", "Parrillas", "Piqueos", "Alitas", "Fríos", "Calientes", "Pastas", "Jugos", "Cocktails", "Cervezas")

        val categoryRecyclerView = findViewById<RecyclerView>(R.id.categoryRecyclerView)
        val dishRecyclerView = findViewById<RecyclerView>(R.id.dishRecyclerView)

        val categoryAdapter = CategoryAdapter(categories) { selectedCategory ->
            val filteredDishes = if (selectedCategory == "All") DishData.allDishes else DishData.allDishes.filter { it.category == selectedCategory }
            dishAdapter.updateData(filteredDishes)
        }

        categoryRecyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        categoryRecyclerView.adapter = categoryAdapter

        // Configurar RecyclerView para platos
        dishAdapter = DishAdapter(DishData.allDishes)
        dishRecyclerView.adapter = dishAdapter
        dishRecyclerView.layoutManager = GridLayoutManager(this, 2)

        val btnPedido = findViewById<Button>(R.id.customButton)
        btnPedido.text = "Ver Pedido"
        btnPedido.visibility = View.VISIBLE
        btnPedido.setOnClickListener {
            val intent = Intent(this, MisPedidosActivity::class.java)
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
