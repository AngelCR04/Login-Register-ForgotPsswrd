package com.example.loginnn

import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton
import android.widget.EditText
import android.widget.ImageView
import android.widget.RadioButton

class RegistrationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)

        // Referencio los elementos de la UI
        val returnIcon: ImageView = findViewById(R.id.returnIcon)
        val registerButton: MaterialButton = findViewById(R.id.registerB)

        returnIcon.setOnClickListener {
            //Ta depreciado pero sirve, amen
            //Posible implementacion: Intent para regresar a la main activity
            onBackPressed()
        }

        registerButton.setOnClickListener {
            // Declarar referencias a los elementos de la IU
            val firstNameEditText: EditText = findViewById(R.id.firstNameEditText)
            val lastNameEditText: EditText = findViewById(R.id.lastNameEditText)
            val phoneEditText: EditText = findViewById(R.id.phoneEditText)
            val emailEditText: EditText = findViewById(R.id.email)
            val passwordEditText: EditText = findViewById(R.id.PasswordEditText)
            val maleRadioButton: RadioButton = findViewById(R.id.maleRadioButton)
            val femaleRadioButton: RadioButton = findViewById(R.id.femaleRadioButton)
            val otherRadioButton: RadioButton = findViewById(R.id.OtherRadioButton)
            val dateOfBirthEditText: EditText = findViewById(R.id.dateOfBirthEditText)
            val countryEditText: EditText = findViewById(R.id.countryEditText)
            val provinceEditText: EditText = findViewById(R.id.Province)
            val addressEditText: EditText = findViewById(R.id.Address)

            // Valido los campos con la clase Validations
            if (Validations.validateFields(
                    firstNameEditText,
                    lastNameEditText,
                    phoneEditText,
                    emailEditText,
                    passwordEditText,
                    maleRadioButton,
                    femaleRadioButton,
                    otherRadioButton,
                    dateOfBirthEditText,
                    countryEditText,
                    provinceEditText,
                    addressEditText
                )
            ) {
                // Campos validados correctamente, se muestra AlertDialog
                showRegistrationAlertDialog()
            }
        }
    }

    //Alert Dialog para mostrar la verificacion
    private fun showRegistrationAlertDialog() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Registration Verification")
        builder.setMessage("An email has been sent to your email address to verify your registration.")
        builder.setPositiveButton("OK") { dialog, _ ->
            dialog.dismiss()
        }

        val alertDialog = builder.create()
        alertDialog.show()
    }
}