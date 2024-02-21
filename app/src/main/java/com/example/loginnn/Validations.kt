package com.example.loginnn

import android.widget.EditText
import android.widget.RadioButton

class Validations {
    companion object {
        fun validateFields(
            firstNameEditText: EditText,
            lastNameEditText: EditText,
            phoneEditText: EditText,
            emailEditText: EditText,
            passwordEditText: EditText,
            maleRadioButton: RadioButton,
            femaleRadioButton: RadioButton,
            otherRadioButton: RadioButton,
            dateOfBirthEditText: EditText,
            countryEditText: EditText,
            provinceEditText: EditText,
            addressEditText: EditText
        ): Boolean {
            var isValid = true

            isValid = validateField(firstNameEditText, "First Name cannot be empty") && isValid
            isValid = validateField(lastNameEditText, "Last Name cannot be empty") && isValid
            isValid = validateField(phoneEditText, "Phone Number cannot be empty") && isValid
            isValid = validateEmail(emailEditText) && isValid
            isValid = validateField(passwordEditText, "Password cannot be empty") && isValid
            isValid = validateGenderField(maleRadioButton, femaleRadioButton, otherRadioButton) && isValid
            isValid = validateDateOfBirth(dateOfBirthEditText.text.toString(), dateOfBirthEditText) && isValid
            isValid = validateField(countryEditText, "Country cannot be empty") && isValid
            isValid = validateField(provinceEditText, "Province cannot be empty") && isValid
            isValid = validateField(addressEditText, "Address cannot be empty") && isValid

            return isValid
        }

        //funcion para validar campos.
        private fun validateField(editText: EditText, errorMessage: String): Boolean {
            val text = editText.text.toString().trim()
            return if (text.isEmpty()) {
                editText.error = errorMessage
                false
            } else {
                true
            }
        }

        //Funcion para validar el campo genero
        private fun validateGenderField(maleRadioButton: RadioButton, femaleRadioButton: RadioButton, otherRadioButton: RadioButton): Boolean {
            return maleRadioButton.isChecked || femaleRadioButton.isChecked || otherRadioButton.isChecked
        }

        //Funcion para validar la fecha con patrón
        private fun validateDateOfBirth(dateOfBirth: String, dateOfBirthEditText: EditText): Boolean {
            //Patrón de fecha que quiero implementar. (Mes dia año)
            val regexPattern = Regex("""^(0[1-9]|1[0-2])/(0[1-9]|[12][0-9]|3[01])/\d{4}$""")

            //Se verifica si la fecha coincide con el patrón que desginé
            val isValid = dateOfBirth.matches(regexPattern)

            //Aqui se maneja el mensaje de error si no es válida la fecha.
            if (!isValid) {
                dateOfBirthEditText.error = "Invalid date format (MM/dd/yyyy)"
            }

            return isValid
        }

        //Funcion para validar el email igualmente con patrón
        fun validateEmail(emailEditText: EditText): Boolean {
            val email = emailEditText.text.toString().trim()
            val emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+"
            return if (email.isEmpty() || !email.matches(emailPattern.toRegex())) {
                emailEditText.error = "Invalid email address"
                false
            } else {
                true
            }
        }
    }
}