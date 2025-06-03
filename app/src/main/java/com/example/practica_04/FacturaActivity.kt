package com.example.practica_04

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity

class FacturaActivity : AppCompatActivity() {

    @SuppressLint("MissingInflatedId", "WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_8_factura)
        val btnBack = findViewById<ImageButton>(R.id.btnBack)
        btnBack.setOnClickListener {
            onBackPressed()
        }


    }


}