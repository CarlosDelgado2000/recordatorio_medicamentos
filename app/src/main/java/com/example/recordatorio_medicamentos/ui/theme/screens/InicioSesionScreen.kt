package com.example.recordatorio_medicamentos.ui.theme.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun InicioSesionScreen(modifier: Modifier = Modifier, onRecoverPasswordClick: () -> Unit, onBackClick: () -> Unit) {
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
            modifier = Modifier.align(Alignment.End) // Alinear a la derecha
        ) {
            Text("Regresar", color = Color.White) // Texto en blanco
        }

        Spacer(modifier = Modifier.height(32.dp))

        Text(
            text = "Login",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(32.dp))

        OutlinedTextField(
            value = "",
            onValueChange = {},
            label = { Text("Correo Electrónico") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = "",
            onValueChange = {},
            label = { Text("Contraseña") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(32.dp))

        Button(
            onClick = { /* Acción de inicio de sesión */ },
            colors = ButtonDefaults.buttonColors(containerColor = Color.Red), // Color del botón "Iniciar sesión"
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

@Preview(showBackground = true)
@Composable
fun PreviewInicioSesionScreen() {
    InicioSesionScreen(onRecoverPasswordClick = {}, onBackClick = {})
}
