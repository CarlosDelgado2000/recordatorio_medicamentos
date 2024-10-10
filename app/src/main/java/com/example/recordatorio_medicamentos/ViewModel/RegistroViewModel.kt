package com.example.recordatorio_medicamentos.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class RegistroViewModel : ViewModel() {

    // Variables para almacenar los datos de registro
    var nombre: String = ""
    var correo: String = ""
    var contrasena: String = ""
    var numeroCelular: String = ""

    // Función para registrar un nuevo usuario
    fun registrarUsuario() {
        viewModelScope.launch {
            // Aquí puedes añadir la lógica para registrar al usuario
            // por ejemplo, llamar a una API o guardar en una base de datos local
            // Asegúrate de manejar errores y mostrar mensajes adecuados
        }
    }
}
