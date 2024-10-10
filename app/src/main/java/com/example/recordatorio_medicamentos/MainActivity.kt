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
                var isRegisterScreenVisible by remember { mutableStateOf(false) } // Estado para la pantalla de registro

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
        InicioSesionScreen(onRecoverPasswordClick = {}, onBackClick = {})
    }
}
