package com.example.recordatorio_medicamentos.ui.theme.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.selection.TextSelectionColors
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.recordatorio_medicamentos.ViewModel.RecuperarCuentaViewModel

@Composable
fun RecuperarCuentaScreen(modifier: Modifier = Modifier) {
    var email by remember { mutableStateOf("") }
    var message by remember { mutableStateOf("") }

    // Instanciar el ViewModel aquí
    val viewModel: RecuperarCuentaViewModel = viewModel()

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Recuperar Cuenta",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(16.dp))

        TextField(
            value = email,
            onValueChange = { email = it },
            modifier = Modifier.fillMaxWidth(),
            label = { Text("Correo electrónico") },
            singleLine = true,
            colors = TextFieldDefaults.colors(
                focusedTextColor = Color.Black,
                unfocusedTextColor = Color.Black,
                disabledTextColor = Color.Gray,
                errorTextColor = Color.Red,
                focusedContainerColor = Color.White,
                unfocusedContainerColor = Color.White,
                disabledContainerColor = Color.LightGray,
                errorContainerColor = Color.LightGray,
                cursorColor = Color.Black,
                errorCursorColor = Color.Red,
                selectionColors = TextSelectionColors(
                    handleColor = Color.Black,
                    backgroundColor = Color.Blue.copy(alpha = 0.4f)
                )
            )
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                viewModel.recuperarCuenta(email)
                message = viewModel.message
            },
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(containerColor = Color.Red)
        ) {
            Text(text = "Recuperar", color = Color.White)
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = message,
            color = Color.Green,
            style = MaterialTheme.typography.bodyMedium
        )
    }
}
