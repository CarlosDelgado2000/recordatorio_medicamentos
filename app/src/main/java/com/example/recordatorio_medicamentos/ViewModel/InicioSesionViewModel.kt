package com.example.recordatorio_medicamentos.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class InicioSesionViewModel : ViewModel() {
    fun iniciarSesion(email: String, password: String, onSuccess: () -> Unit, onError: (String) -> Unit) {
        viewModelScope.launch {
            if (email.isNotEmpty() && password.isNotEmpty()) {
                onSuccess()
            } else {
                onError("Por favor, completa todos los campos.")
            }
        }
    }
}
