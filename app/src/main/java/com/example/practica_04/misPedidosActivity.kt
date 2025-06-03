package com.example.practica_04


import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.GridLayoutManager
class misPedidosActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_7_mispedidos)

        val btnVer1 = findViewById<Button>(R.id.btnVer1)
        btnVer1.setOnClickListener {
            val intent = Intent(this, PedidoActivity::class.java)
            startActivity(intent)
        }
        val btnAgregar = findViewById<Button>(R.id.btnFactura)
        btnAgregar.setOnClickListener {
            val intent = Intent(this, FacturaActivity::class.java)
            startActivity(intent)
        }
        val btnAgregar2 = findViewById<Button>(R.id.btnFactura2)
        btnAgregar2.setOnClickListener {
            val intent = Intent(this, FacturaActivity::class.java)
            startActivity(intent)
        }

    }








}