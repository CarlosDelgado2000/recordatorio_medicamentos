package com.example.recordatorio_medicamentos.ViewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class RecuperarCuentaViewModel : ViewModel() {
    var message by mutableStateOf("")

    fun recuperarCuenta(email: String) {
        viewModelScope.launch {
            // Simulación de recuperación de cuenta (lógica real aquí)
            if (email.isNotEmpty()) {
                message = "Instrucciones enviadas a $email"
            } else {
                message = "Por favor, ingresa un correo electrónico."
            }
        }
    }
}
