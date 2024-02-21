package com.example.loginnn

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton

class AccountInformationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_information)

        // Asigno los valores a UserData
        UserData.firstName = "Ángel"
        UserData.lastName = "Cordero"
        UserData.phone = "123456789"
        UserData.email = "angelj.cordero@hotmail.com"
        UserData.gender = "Male"
        UserData.dateOfBirth = "01/04/03"
        UserData.country = "Dominican Republic"
        UserData.province = "SPM"
        UserData.address = "La bolaita #123"

        //Le paso los valores de texto a mis TextViews
        val nameTextView: TextView = findViewById(R.id.nameTextView)
        nameTextView.text = "First Name: ${UserData.firstName}"

        val lastNameTextView: TextView = findViewById(R.id.lastNameTextView)
        lastNameTextView.text = "Last Name: ${UserData.lastName}"

        val phoneTextView: TextView = findViewById(R.id.phoneTextView)
        phoneTextView.text = "Phone: ${UserData.phone}"

        val emailTextView: TextView = findViewById(R.id.emailTextView)
        emailTextView.text = "Email: ${UserData.email}"

        val genderTextView: TextView = findViewById(R.id.genderTextView)
        genderTextView.text = "Gender: ${UserData.gender}"

        val dateOfBirthText: TextView = findViewById(R.id.dateOfBirthText)
        dateOfBirthText.text = "Date of Birth: ${UserData.dateOfBirth}"

        val countryTextView: TextView = findViewById(R.id.countryTextView)
        countryTextView.text = "Country: ${UserData.country}"

        val provinceTextView: TextView = findViewById(R.id.provinceTextView)
        provinceTextView.text = "Province: ${UserData.province}"

        val addressTextView: TextView = findViewById(R.id.addressTextView)
        addressTextView.text = "Address: ${UserData.address}"


        val logoutButton: MaterialButton = findViewById(R.id.logoutB)

        //Configuro un listener para el click en el botón de logout
        logoutButton.setOnClickListener {
            //Creo un Intent para hacer return a MainActivity
            val intent = Intent(this, MainActivity::class.java)

            //Utilizo banderas para limpiar las actividades
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK

            //Inicio la actividad principal
            startActivity(intent)

            //Cierro la actividad actual
            finish()
        }

    }
}

