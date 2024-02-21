package com.example.loginnn

import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton

class MainActivity : AppCompatActivity() {

    // Usuario de ejemplo (deberías gestionar esto de forma segura)
    private val sampleEmail = "angelcordero@gmail.com"
    private val samplePassword = "Angel123"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val forgotPasswordTextView: TextView = findViewById(R.id.forgotPasswordTextView)
        val registerTextView: TextView = findViewById(R.id.registerTextView)
        val loginButton: MaterialButton = findViewById(R.id.loginButton)
        val emailEditText: EditText = findViewById(R.id.emailEditText)
        val passwordEditText: EditText = findViewById(R.id.passwordEditText)


        forgotPasswordTextView.setOnClickListener {
            val intent = Intent(this, RecoveryActivity::class.java)
            startActivity(intent)
        }

        registerTextView.setOnClickListener {
            val intent = Intent(this, RegistrationActivity::class.java)
            startActivity(intent)
        }

        loginButton.setOnClickListener {
            // Obtengo el texto de los campos de correo electrónico y contraseña
            val email = emailEditText.text.toString()
            val password = passwordEditText.text.toString()

            // Con esta condición compruebo si los campos están vacíos y envío un pequeño mensaje para que se llenen los campos
            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show()
            } //Si no están vacios, entonces se valida el formato de correo electrónico, si dicho correo es correcto, y si la contraseña es correcta.
             else {

                if (email == sampleEmail && Validations.validateEmail(emailEditText) && password == samplePassword) {
                    // Si las credenciales son correctas, se inicia la siguiente actividad.
                    val intent = Intent(this, AccountInformationActivity::class.java)
                    startActivity(intent)
                } else {
                    // En caso contrario, se muestra el mensaje de invalidez de credenciales.
                    Toast.makeText(this, "Invalid email or password", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}