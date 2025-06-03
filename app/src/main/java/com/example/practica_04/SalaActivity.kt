package com.example.practica_04

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.view.animation.AlphaAnimation
import android.view.animation.AnimationSet
import android.view.animation.TranslateAnimation
import android.widget.ImageButton
import android.widget.TextView

class SalaActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_4_sala_espera)

        val btnMenu = findViewById<Button>(R.id.customButton)

        btnMenu.setOnClickListener {
            val intent = Intent(this, MenuActivity::class.java)
            startActivity(intent)  // Lanza la nueva actividad
        }

        val btnBack = findViewById<ImageButton>(R.id.btnBack)
        btnBack.setOnClickListener {
            onBackPressed()
        }

        val fadeIn = AlphaAnimation(0f, 1f)
        fadeIn.duration = 1500 // Duración de la animación en milisegundos
        fadeIn.repeatMode = AlphaAnimation.REVERSE // Hace que la animación vuelva a su estado original
        fadeIn.repeatCount = AlphaAnimation.INFINITE // Hace que la animación se repita infinitamente

        // Crear la animación de movimiento (desplazarse hacia abajo en el eje Y)
        val move = TranslateAnimation(0f, 0f, -100f, 0f) // Movimiento de -100px en el eje Y
        move.duration = 1500
        move.repeatMode = TranslateAnimation.REVERSE
        move.repeatCount = TranslateAnimation.INFINITE

        // Combinar ambas animaciones
        val animationSet = AnimationSet(true)
        animationSet.addAnimation(fadeIn)
        animationSet.addAnimation(move)

        // Obtener el TextView
        val mensajeAlentador = findViewById<TextView>(R.id.mensajeAlentador)

        // Iniciar la animación combinada
        mensajeAlentador.startAnimation(animationSet)
    }
}
