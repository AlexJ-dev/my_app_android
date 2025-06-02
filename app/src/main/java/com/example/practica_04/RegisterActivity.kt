package com.example.practica_04

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.*
import android.text.InputType
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class RegisterActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_2_registro)

        // Asignación de textos a las vistas
        mapOf(
            R.id.textRegister to "Registro",
            R.id.inputResName to "Nombre",
            R.id.inputResLastName to "Apellido",
            R.id.inputResPass to "Contraseña",
            R.id.inputResConfirmPass to "Confirmar Contraseña"
        ).forEach { (parentId, text) ->
            findViewById<View>(parentId)?.findViewById<TextView>(R.id.labelText)?.text = text
        }

        // Configurar la entrada de contraseñas
        listOf(R.id.inputResPass, R.id.inputResConfirmPass).forEach { id ->
            findViewById<View>(id)?.findViewById<EditText>(R.id.editTextInput)?.inputType =
                InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD
        }

        // Botón de registro
        findViewById<Button>(R.id.customButton)?.apply {
            text = "Registrate"
            setOnClickListener {
                val inputs = listOf(
                    R.id.inputResName,
                    R.id.inputResLastName,
                    R.id.inputResPass,
                    R.id.inputResConfirmPass
                ).map { id -> findViewById<View>(id)?.findViewById<EditText>(R.id.editTextInput)?.text.toString() }

                val (name, lastName, password, confirmPassword) = inputs

                when {
                    inputs.any { it.isEmpty() } -> Toast.makeText(this@RegisterActivity, "Completa todos los campos", Toast.LENGTH_SHORT).show()
                    password != confirmPassword -> Toast.makeText(this@RegisterActivity, "Las contraseñas no coinciden", Toast.LENGTH_SHORT).show()
                    else -> {
                        Toast.makeText(this@RegisterActivity, "Registrado correctamente", Toast.LENGTH_SHORT).show()
                        startActivity(Intent(this@RegisterActivity, MesasActivity::class.java))
                        finish()
                    }
                }
            }
        }

        // Redirección al login
        findViewById<TextView>(R.id.loginRedirectText)?.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }
    }
}

