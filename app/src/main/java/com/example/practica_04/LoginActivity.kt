package com.example.practica_04

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.text.InputType
import android.widget.*
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {

    @SuppressLint("CutPasteId", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_1_login)

        mapOf(
            R.id.textLogin to "Login",
            R.id.inputLogUser to "Usuario",
            R.id.inputLogPass to "Contraseña"
        ).forEach { (parentId, text) ->
            findViewById<View>(parentId)?.findViewById<TextView>(R.id.labelText)?.text = text
        }

        // Configurar la entrada de contraseña
        findViewById<View>(R.id.inputLogPass)?.findViewById<EditText>(R.id.editTextInput)?.inputType =
            InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD

        findViewById<Button>(R.id.customButton)?.apply {
            text = "Login"
            setOnClickListener {
                val user = findViewById<View>(R.id.inputLogUser)?.findViewById<EditText>(R.id.editTextInput)?.text.toString()
                val pass = findViewById<View>(R.id.inputLogPass)?.findViewById<EditText>(R.id.editTextInput)?.text.toString()

                val mensaje = if (user.isEmpty() || pass.isEmpty()) "Campos vacíos" else "Login exitoso"
                Toast.makeText(this@LoginActivity, mensaje, Toast.LENGTH_SHORT).show()
                // Redirigir a MesasActivity
                if (user.isNotEmpty() && pass.isNotEmpty()) {
                    startActivity(Intent(this@LoginActivity, MesasActivity::class.java))
                }
            }
        }

        findViewById<TextView>(R.id.registerTextView)?.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }
    }
}
