package com.example.recordatorio_medicamentos.ViewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class RegistroViewModel : ViewModel() {
    var nombre by mutableStateOf("")
    var correo by mutableStateOf("")
    var contrasena by mutableStateOf("")
    var numeroCelular by mutableStateOf("")
    var errorMessage by mutableStateOf<String?>(null)
    var successMessage by mutableStateOf<String?>(null)

    fun registrarUsuario(onSuccess: () -> Unit) {
        // Resetea mensajes de error y éxito
        errorMessage = null
        successMessage = null

        // Validación de campos
        when {
            nombre.isEmpty() -> errorMessage = "El nombre y apellido son obligatorios."
            correo.isEmpty() -> errorMessage = "El correo es obligatorio."
            contrasena.isEmpty() -> errorMessage = "La contraseña es obligatoria."
            numeroCelular.isEmpty() -> errorMessage = "El número celular es obligatorio."
            else -> {
                // Lógica de registro aquí
                // Si el registro es exitoso
                successMessage = "Registro exitoso."
                onSuccess()
            }
        }
    }
}
