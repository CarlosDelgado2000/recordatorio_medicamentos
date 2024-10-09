package com.example.recordatorio_medicamentos

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.recordatorio_medicamentos.ui.theme.Recordatorio_medicamentosTheme
import com.example.recordatorio_medicamentos.ui.theme.screens.RecuperarCuentaScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Recordatorio_medicamentosTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    // Cambia la pantalla de saludo por la pantalla de recuperar cuenta
                    RecuperarCuentaScreen(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewRecuperarCuentaScreen() {
    Recordatorio_medicamentosTheme {
        RecuperarCuentaScreen() // Muestra una vista previa de la pantalla de recuperación
    }
}
