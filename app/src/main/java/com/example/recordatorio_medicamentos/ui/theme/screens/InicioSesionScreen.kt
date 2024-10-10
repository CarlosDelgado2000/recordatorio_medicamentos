package com.example.recordatorio_medicamentos.ui.theme.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.unit.dp

@Composable
fun InicioSesionScreen(
    modifier: Modifier = Modifier,
    onRecoverPasswordClick: () -> Unit,
    onBackClick: () -> Unit,
    onLoginClick: (String, String) -> Unit // Se pasa la función para el evento de login
) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var showError by remember { mutableStateOf(false) }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Botón "Regresar"
        Button(
            onClick = onBackClick,
            colors = ButtonDefaults.buttonColors(containerColor = Color.Red),
            modifier = Modifier.align(Alignment.End)
        ) {
            Text("Regresar", color = Color.White)
        }

        Spacer(modifier = Modifier.height(32.dp))

        Text(
            text = "Login",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(32.dp))

        OutlinedTextField(
            value = email,
            onValueChange = {
                email = it
                showError = false
            },
            label = { Text("Correo Electrónico") },
            placeholder = { Text("Por favor ingrese su usuario o correo electrónico") },
            modifier = Modifier.fillMaxWidth()
        )

        if (showError && email.isEmpty()) {
            Text(
                text = "Este campo es obligatorio",
                color = Color.Red,
                style = MaterialTheme.typography.bodySmall
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = password,
            onValueChange = {
                password = it
                showError = false
            },
            label = { Text("Contraseña") },
            placeholder = { Text("Por favor ingrese su contraseña") },
            modifier = Modifier.fillMaxWidth()
        )

        if (showError && password.isEmpty()) {
            Text(
                text = "Este campo es obligatorio",
                color = Color.Red,
                style = MaterialTheme.typography.bodySmall
            )
        }

        Spacer(modifier = Modifier.height(32.dp))

        Button(
            onClick = {
                if (email.isEmpty() || password.isEmpty()) {
                    showError = true
                } else {
                    onLoginClick(email, password) // Llamada al callback de login
                }
            },
            colors = ButtonDefaults.buttonColors(containerColor = Color.Red),
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Iniciar Sesión", color = Color.White)
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Texto para recuperar contraseña
        Text(
            text = buildAnnotatedString {
                append("¿Olvidaste tu contraseña? ")
                pushStyle(MaterialTheme.typography.bodyMedium.toSpanStyle().copy(color = Color.Blue))
                append("Recuperar")
                pop()
            },
            modifier = Modifier.clickable(onClick = onRecoverPasswordClick),
            color = Color.Gray,
            style = MaterialTheme.typography.bodyMedium
        )
    }
}
