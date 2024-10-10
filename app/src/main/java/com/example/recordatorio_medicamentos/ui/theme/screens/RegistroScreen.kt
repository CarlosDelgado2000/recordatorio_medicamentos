package com.example.recordatorio_medicamentos.ui.theme.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.material3.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check

@Composable
fun RegistroScreen(
    modifier: Modifier = Modifier,
    onRegisterSuccess: () -> Unit,
    onBackClick: () -> Unit
) {
    var nombre by remember { mutableStateOf("") }
    var apellido by remember { mutableStateOf("") }
    var correo by remember { mutableStateOf("") }
    var contrasena by remember { mutableStateOf("") }
    var numeroCelular by remember { mutableStateOf("") }

    // Variables para manejar los mensajes de error
    var nombreError by remember { mutableStateOf("") }
    var apellidoError by remember { mutableStateOf("") }
    var correoError by remember { mutableStateOf("") }
    var contrasenaError by remember { mutableStateOf("") }
    var numeroCelularError by remember { mutableStateOf("") }

    // Variable para manejar el mensaje de registro exitoso
    var registroExitoso by remember { mutableStateOf(false) }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        // Botón "Volver" en la parte superior derecha
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.End
        ) {
            Button(
                onClick = onBackClick,
                colors = ButtonDefaults.buttonColors(containerColor = Color.Red) // Color rojo
            ) {
                Text("Volver", color = Color.White)
            }
        }

        Spacer(modifier = Modifier.height(32.dp)) // Espacio entre el botón y el título

        Text(
            text = "Registro",
            style = MaterialTheme.typography.headlineMedium,
            color = Color.Red // Color del título
        )

        Spacer(modifier = Modifier.height(32.dp)) // Espacio entre el título y los campos

        // Mostrar mensaje de registro exitoso con ícono
        if (registroExitoso) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(imageVector = Icons.Filled.Check, contentDescription = "Registro exitoso", tint = Color.Green)
                Spacer(modifier = Modifier.width(4.dp))
                Text("Registro exitoso", color = Color.Green)
            }
        }

        Spacer(modifier = Modifier.height(16.dp)) // Espacio entre el mensaje y los campos

        // Campos de texto
        OutlinedTextField(
            value = nombre,
            onValueChange = { nombre = it; nombreError = "" },
            label = { Text("Nombre") },
            isError = nombreError.isNotEmpty(),
            modifier = Modifier.fillMaxWidth()
        )
        if (nombreError.isNotEmpty()) {
            Text(nombreError, color = Color.Red)
        }

        Spacer(modifier = Modifier.height(8.dp)) // Espacio entre campos

        OutlinedTextField(
            value = apellido,
            onValueChange = { apellido = it; apellidoError = "" },
            label = { Text("Apellido") },
            isError = apellidoError.isNotEmpty(),
            modifier = Modifier.fillMaxWidth()
        )
        if (apellidoError.isNotEmpty()) {
            Text(apellidoError, color = Color.Red)
        }

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = correo,
            onValueChange = { correo = it; correoError = "" },
            label = { Text("Correo") },
            isError = correoError.isNotEmpty(),
            modifier = Modifier.fillMaxWidth()
        )
        if (correoError.isNotEmpty()) {
            Text(correoError, color = Color.Red)
        }

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = contrasena,
            onValueChange = { contrasena = it; contrasenaError = "" },
            label = { Text("Contraseña") },
            isError = contrasenaError.isNotEmpty(),
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier.fillMaxWidth()
        )
        if (contrasenaError.isNotEmpty()) {
            Text(contrasenaError, color = Color.Red)
        }

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = numeroCelular,
            onValueChange = { numeroCelular = it; numeroCelularError = "" },
            label = { Text("Número Celular") },
            isError = numeroCelularError.isNotEmpty(),
            modifier = Modifier.fillMaxWidth()
        )
        if (numeroCelularError.isNotEmpty()) {
            Text(numeroCelularError, color = Color.Red)
        }

        Spacer(modifier = Modifier.height(32.dp)) // Espacio antes del botón de registrar

        // Botón de registrar al final
        Button(
            onClick = {
                // Validaciones
                nombreError = if (nombre.isBlank()) "Campo requerido" else ""
                apellidoError = if (apellido.isBlank()) "Campo requerido" else ""
                correoError = if (correo.isBlank()) "Campo requerido" else ""
                contrasenaError = if (contrasena.isBlank()) "Campo requerido" else ""
                numeroCelularError = if (numeroCelular.isBlank()) "Campo requerido" else ""

                // Si todos los campos son válidos, se llama a onRegisterSuccess
                if (nombreError.isEmpty() && apellidoError.isEmpty() &&
                    correoError.isEmpty() && contrasenaError.isEmpty() &&
                    numeroCelularError.isEmpty()
                ) {
                    registroExitoso = true // Mostrar mensaje de registro exitoso
                    onRegisterSuccess() // Mostrar otra lógica si es necesario
                }
            },
            colors = ButtonDefaults.buttonColors(containerColor = Color.Red), // Color rojo
            modifier = Modifier.fillMaxWidth() // Botón a todo el ancho
        ) {
            Text("Registrar", color = Color.White)
        }
    }
}
