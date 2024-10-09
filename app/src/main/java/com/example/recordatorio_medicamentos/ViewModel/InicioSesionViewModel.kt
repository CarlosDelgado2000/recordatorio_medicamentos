package com.example.recordatorio_medicamentos.ViewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class InicioSesionViewModel : ViewModel() {
    var message by mutableStateOf("")

    fun iniciarSesion(email: String, password: String) {
        viewModelScope.launch {
            // Simulación de inicio de sesión (lógica real aquí)
            if (email.isNotEmpty() && password.isNotEmpty()) {
                message = "Bienvenido, $email"
            } else {
                message = "Por favor, completa todos los campos."
            }
        }
    }
}
