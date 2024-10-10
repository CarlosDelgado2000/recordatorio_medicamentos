package com.example.recordatorio_medicamentos

import PortadaScreen
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.recordatorio_medicamentos.ui.theme.Recordatorio_medicamentosTheme
import com.example.recordatorio_medicamentos.ui.theme.screens.InicioSesionScreen
import com.example.recordatorio_medicamentos.ui.theme.screens.MedicamentoScreen // Import the MedicamentoScreen
import com.example.recordatorio_medicamentos.ui.theme.screens.RecuperarCuentaScreen
import com.example.recordatorio_medicamentos.ui.theme.screens.RegistroScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Recordatorio_medicamentosTheme {
                // Estado para controlar la visibilidad de las pantallas
                var isLoginScreenVisible by remember { mutableStateOf(false) }
                var isRecoverPasswordScreenVisible by remember { mutableStateOf(false) }
                var isRegisterScreenVisible by remember { mutableStateOf(false) }
                var isMedicamentoScreenVisible by remember { mutableStateOf(false) }

                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    when {
                        isRecoverPasswordScreenVisible -> {
                            RecuperarCuentaScreen(
                                modifier = Modifier.padding(innerPadding),
                                onBackClick = {
                                    isRecoverPasswordScreenVisible = false // Volver a la pantalla anterior
                                    isLoginScreenVisible = true // Volver a la pantalla de inicio de sesión
                                }
                            )
                        }
                        isRegisterScreenVisible -> {
                            RegistroScreen(
                                modifier = Modifier.padding(innerPadding),
                                onBackClick = {
                                    isRegisterScreenVisible = false // Volver a la pantalla anterior
                                },
                                onRegisterSuccess = {
                                    isRegisterScreenVisible = false // Oculta la pantalla de registro
                                    isLoginScreenVisible = true // Muestra la pantalla de inicio de sesión
                                }
                            )
                        }
                        isMedicamentoScreenVisible -> {
                            MedicamentoScreen(
                                modifier = Modifier.padding(innerPadding),
                                onLogoutClick = {
                                    // Lógica para manejar el cierre de sesión
                                    isMedicamentoScreenVisible = false // Oculta la pantalla de medicamentos
                                    isLoginScreenVisible = true // Regresa a la pantalla de inicio de sesión
                                },
                                onViewAgendaClick = {
                                    // Lógica para manejar la visualización de la agenda
                                    // Implementa tu lógica aquí
                                }
                            )
                        }
                        isLoginScreenVisible -> {
                            InicioSesionScreen(
                                modifier = Modifier.padding(innerPadding),
                                onRecoverPasswordClick = {
                                    isRecoverPasswordScreenVisible = true // Muestra la pantalla de recuperación de cuenta
                                    isLoginScreenVisible = false // Oculta la pantalla de inicio de sesión
                                },
                                onBackClick = {
                                    isLoginScreenVisible = false // Volver a la pantalla anterior
                                },
                                onLoginClick = { email, password ->
                                    // Aquí defines la lógica que quieres que suceda al hacer clic en "Iniciar Sesión"
                                    // Puedes implementar la autenticación o cualquier otra lógica

                                    // Suponiendo que la autenticación es exitosa:
                                    isLoginScreenVisible = false // Oculta la pantalla de inicio de sesión
                                    isMedicamentoScreenVisible = true // Muestra la pantalla de medicamentos
                                    println("Iniciar sesión con correo: $email y contraseña: $password")
                                }
                            )
                        }
                        else -> {
                            PortadaScreen(
                                modifier = Modifier.padding(innerPadding),
                                onLoginClick = {
                                    isLoginScreenVisible = true // Cambia el estado para mostrar la pantalla de inicio de sesión
                                },
                                onRegisterClick = {
                                    isRegisterScreenVisible = true // Muestra la pantalla de registro
                                }
                            )
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewPortadaScreen() {
    Recordatorio_medicamentosTheme {
        PortadaScreen(onLoginClick = {}, onRegisterClick = {})
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewInicioSesionScreen() {
    Recordatorio_medicamentosTheme {
        InicioSesionScreen(
            onRecoverPasswordClick = {},
            onBackClick = {},
            onLoginClick = { _, _ -> }
        )
    }
}
