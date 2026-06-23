package com.example.miproyecto

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    // Declaración de variables
    private lateinit var etUsuario: EditText
    private lateinit var etContrasena: EditText
    private lateinit var btnLogin: Button
    private lateinit var tvError: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(
                systemBars.left,
                systemBars.top,
                systemBars.right,
                systemBars.bottom
            )
            insets
        }

        // Inicialización de variables
        etUsuario = findViewById(R.id.etUsuario)
        etContrasena = findViewById(R.id.etContrasena)
        btnLogin = findViewById(R.id.btnLogin)
        tvError = findViewById(R.id.tvError)

        // Evento click del botón
        btnLogin.setOnClickListener {

            val usuario = etUsuario.text.toString().trim()
            val contrasena = etContrasena.text.toString().trim()

            // Validar campos vacíos
            if (usuario.isEmpty() || contrasena.isEmpty()) {
                tvError.text = "Completa todos los campos"
                return@setOnClickListener
            }

            // Validación de usuario y contraseña
            if (usuario == "admin") {

                if (contrasena == "123456") {

                    tvError.text = ""

                    val intento = Intent(this, Principal::class.java)
                    startActivity(intento)
                    finish()

                } else {
                    tvError.text = "Contraseña incorrecta"
                }

            } else {
                tvError.text = "Usuario incorrecto"
            }
        }
    }
}