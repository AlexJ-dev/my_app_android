package com.example.practica_04

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.animation.AlphaAnimation
import android.view.animation.AnimationSet
import android.view.animation.TranslateAnimation
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import com.google.android.material.bottomnavigation.BottomNavigationView

class SalaActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_4_sala_espera)

        // Botón de regreso
        val btnBack = findViewById<ImageButton>(R.id.btnBack)
        btnBack.setOnClickListener {
            onBackPressed()
        }
        val textSalaEspera =  findViewById<View>(R.id.textSala)
            textSalaEspera?.findViewById<TextView>(R.id.texto)?.text="Sala de Espera"

        // Animaciones para el mensaje alentador
        val fadeIn = AlphaAnimation(0f, 1f).apply {
            duration = 1500
            repeatMode = AlphaAnimation.REVERSE
            repeatCount = AlphaAnimation.INFINITE
        }

        val move = TranslateAnimation(0f, 0f, -100f, 0f).apply {
            duration = 1500
            repeatMode = TranslateAnimation.REVERSE
            repeatCount = TranslateAnimation.INFINITE
        }

        val animationSet = AnimationSet(true).apply {
            addAnimation(fadeIn)
            addAnimation(move)
        }
        // Lista de mensajes motivacionales con emojis
        val mensajesList = listOf(
            Mensaje("😊 Siempre Sonríe", "😊"),
            Mensaje("👂 Escucha con Atención", "👂"),
            Mensaje("📖 Conoce la carta", "📖"),
            Mensaje("📝 Organízate bien", "📝"),
            Mensaje("👀 Observa a los clientes", "👀")
        )

        // Configuración del RecyclerView para los mensajes motivacionales
        val recyclerMensajes = findViewById<RecyclerView>(R.id.recyclerMensajes)
        recyclerMensajes.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recyclerMensajes.adapter = MensajesAdapter(mensajesList)
        recyclerMensajes.clipToPadding = false

        // Configurar el botón para ir al menú de categorías
        val btnMenu = findViewById<Button>(R.id.customButton)
        btnMenu.text = "Iniciar Pepido"
        btnMenu.setOnClickListener {
            val intent = Intent(this, CategoryActivity::class.java)
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
