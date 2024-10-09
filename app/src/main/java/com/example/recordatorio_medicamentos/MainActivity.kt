package com.example.recordatorio_medicamentos

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
import com.example.recordatorio_medicamentos.ui.theme.screens.PortadaScreen
import com.example.recordatorio_medicamentos.ui.theme.screens.RecuperarCuentaScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Recordatorio_medicamentosTheme {
                // Estado para controlar la visibilidad de las pantallas
                var isLoginScreenVisible by remember { mutableStateOf(false) }
                var isRecoverPasswordScreenVisible by remember { mutableStateOf(false) }

                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    when {
                        isRecoverPasswordScreenVisible -> {
                            RecuperarCuentaScreen(modifier = Modifier.padding(innerPadding))
                        }
                        isLoginScreenVisible -> {
                            InicioSesionScreen(
                                modifier = Modifier.padding(innerPadding),
                                onRecoverPasswordClick = {
                                    isRecoverPasswordScreenVisible = true // Muestra la pantalla de recuperación de cuenta
                                    isLoginScreenVisible = false // Opcional: Oculta la pantalla de inicio de sesión
                                }
                            )
                        }
                        else -> {
                            PortadaScreen(
                                modifier = Modifier.padding(innerPadding),
                                onLoginClick = {
                                    isLoginScreenVisible = true // Cambia el estado para mostrar la pantalla de inicio de sesión
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
        PortadaScreen(onLoginClick = {})
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewInicioSesionScreen() {
    Recordatorio_medicamentosTheme {
        InicioSesionScreen(onRecoverPasswordClick = {})
    }
}
