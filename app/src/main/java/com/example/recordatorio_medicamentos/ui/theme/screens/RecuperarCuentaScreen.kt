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

@OptIn(ExperimentalMaterial3Api::class) // Suppress the experimental API warning
@Composable
fun RecuperarCuentaScreen(modifier: Modifier = Modifier, onBackClick: () -> Unit) {
    var email by remember { mutableStateOf("") }
    var verificationCode by remember { mutableStateOf("") }
    var newPassword by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }
    var message by remember { mutableStateOf("") }
    var isCodeSent by remember { mutableStateOf(false) }

    // Instanciar el ViewModel aquí
    val viewModel: RecuperarCuentaViewModel = viewModel()

    Column(modifier = modifier.fillMaxSize()) {
        // Barra de herramientas en la parte superior
        // Botón "Regresar"
        Button(
            onClick = onBackClick,
            colors = ButtonDefaults.buttonColors(containerColor = Color.Red),
            modifier = Modifier.align(Alignment.End) // Alinear a la derecha
        ) {
            Text("Regresar", color = Color.White) // Texto en blanco
        }

        Spacer(modifier = Modifier.height(32.dp))

        TopAppBar(
            title = {
                Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
                    Text("Recuperar Cuenta")
                }
            },
        )


        // Contenido de la pantalla
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Spacer(modifier = Modifier.height(16.dp))

            if (!isCodeSent) {
                // Campos para ingresar el correo y enviar el código
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
                        if (email.isNotEmpty()) {
                            isCodeSent = true // Cambia el estado para mostrar los campos del código
                        }
                    },
                    modifier = Modifier.fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Red)
                ) {
                    Text(text = "Recuperar", color = Color.White)
                }

                Spacer(modifier = Modifier.height(16.dp))

            } else {
                // Campos para ingresar el código de verificación y la nueva contraseña
                TextField(
                    value = verificationCode,
                    onValueChange = { verificationCode = it },
                    modifier = Modifier.fillMaxWidth(),
                    label = { Text("Código de verificación") },
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

                TextField(
                    value = newPassword,
                    onValueChange = { newPassword = it },
                    modifier = Modifier.fillMaxWidth(),
                    label = { Text("Nueva contraseña") },
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

                TextField(
                    value = confirmPassword,
                    onValueChange = { confirmPassword = it },
                    modifier = Modifier.fillMaxWidth(),
                    label = { Text("Verificar contraseña") },
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
                        // Aquí se debe agregar la lógica para confirmar la nueva contraseña y verificar el código
                        if (newPassword == confirmPassword) {
                            message = "Contraseña actualizada exitosamente."
                        } else {
                            message = "Las contraseñas no coinciden."
                        }
                    },
                    modifier = Modifier.fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Red)
                ) {
                    Text(text = "Actualizar contraseña", color = Color.White)
                }

                Spacer(modifier = Modifier.height(16.dp))
            }

            Text(
                text = message,
                color = if (message.startsWith("Instrucciones") || message.startsWith("Contraseña")) Color.Green else Color.Red,
                style = MaterialTheme.typography.bodyMedium
            )

            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}
