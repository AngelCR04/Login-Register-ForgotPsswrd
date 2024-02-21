package com.example.loginnn

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputLayout
import android.widget.EditText
import android.widget.ImageView
import androidx.appcompat.app.AlertDialog

class RecoveryActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recovery)

        //Establezco los elementos de mi UI
        val returnIcon: ImageView = findViewById(R.id.returnIcon)
        val emailEditText: EditText = findViewById(R.id.emailEditText)
        val recoveryButton: MaterialButton = findViewById(R.id.recoveryB)

        returnIcon.setOnClickListener {
            //depreciao
            onBackPressed()
        }

        recoveryButton.setOnClickListener {
            if (Validations.validateEmail(emailEditText)) {
                // Email válido, se muestra AlertDialog
                showRecoveryAlertDialog()
                // Limpio el error, por si está presente
                emailEditText.error = null
            } else {
                // Email no válido
            }
        }
    }
    //Alert dialog para reset de password
    private fun showRecoveryAlertDialog() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Password Recovery")
        builder.setMessage("An email has been sent to your email address to reset your password.")
        builder.setPositiveButton("OK") { dialog, _ ->
            dialog.dismiss()
        }

        val alertDialog = builder.create()
        alertDialog.show()
    }
}