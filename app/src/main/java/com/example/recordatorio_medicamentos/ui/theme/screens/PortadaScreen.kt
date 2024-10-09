package com.example.recordatorio_medicamentos.ui.theme.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.recordatorio_medicamentos.R // Asegúrate de tener la importación correcta

@Composable
fun PortadaScreen(modifier: Modifier = Modifier, onLoginClick: () -> Unit) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Button(
            onClick = onLoginClick,
            modifier = Modifier.align(Alignment.End) // Alinear a la derecha
        ) {
            Text("Iniciar Sesión")
        }

        Spacer(modifier = Modifier.height(32.dp))

        Text(
            text = "¡Bienvenido!",
            color = Color.Red,
            style = MaterialTheme.typography.headlineMedium,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(16.dp))

        //Image(
        //painter = painterResource(id = R.drawable.your_image), // Asegúrate de que la imagen esté en res/drawable
        //contentDescription = null,
        //modifier = Modifier.size(200.dp) // Ajusta el tamaño de la imagen
        //)

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Aquí, te ayudamos a mantener el control de tu bienestar recordándote tomar tus medicamentos a tiempo.\n" +
                    "Porque cada dosis es un paso hacia sentirte mejor. ¡Estamos aquí para cuidarte y acompañarte en tu camino hacia la salud!",
            color = Color.Black,
            style = MaterialTheme.typography.bodyMedium,
            textAlign = TextAlign.Center
        )
    }
}
