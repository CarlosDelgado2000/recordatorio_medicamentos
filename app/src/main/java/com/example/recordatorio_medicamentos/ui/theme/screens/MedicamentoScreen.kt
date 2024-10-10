package com.example.recordatorio_medicamentos.ui.theme.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.ui.res.painterResource
import com.example.recordatorio_medicamentos.R

// Modelo de Medicamento
data class Medicamento(val id: Int, val nombre: String)

// Lista simulada de medicamentos
private val medicamentos = listOf(
    Medicamento(1, "Paracetamol"),
    Medicamento(2, "Ibuprofeno"),
    Medicamento(3, "Amoxicilina"),
    Medicamento(4, "Cetirizina"),
    Medicamento(5, "Losartán"),
    // Agrega más medicamentos según sea necesario
)

@Composable
fun MedicamentoScreen(
    modifier: Modifier = Modifier,
    onLogoutClick: () -> Unit,
    onViewAgendaClick: () -> Unit
) {
    // Estado para el valor del buscador
    var searchQuery by remember { mutableStateOf("") }
    // Estado para la lista de medicamentos filtrados
    var filteredMedicamentos by remember { mutableStateOf(medicamentos) }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        // Fila para la imagen y el botón de "Cerrar sesión"
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.img_1), // Cambia el ID de la imagen si es necesario
                contentDescription = null,
                modifier = Modifier.size(80.dp)
            )
            Button(
                onClick = onLogoutClick,
                colors = ButtonDefaults.buttonColors(containerColor = Color.Red)
            ) {
                Text("Cerrar sesión", color = Color.White)
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Buscador de medicamento
        OutlinedTextField(
            value = searchQuery,
            onValueChange = { newValue ->
                searchQuery = newValue
                // Filtrar la lista de medicamentos según el texto ingresado
                filteredMedicamentos = medicamentos.filter { medicamento ->
                    medicamento.nombre.contains(searchQuery, ignoreCase = true)
                }
            },
            label = { Text("Buscar medicamento") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            trailingIcon = {
                IconButton(onClick = {
                    // Lógica para buscar el medicamento
                    buscarMedicamento(searchQuery)
                }) {
                    Icon(
                        imageVector = Icons.Filled.Search,
                        contentDescription = "Buscar",
                        tint = Color.Gray
                    )
                }
            }
        )

        Spacer(modifier = Modifier.height(32.dp))

        // Texto motivacional
        Text(
            text = "Recuerda, cada pastilla es un paso hacia una vida más saludable.\n¡No olvides tu medicamento hoy!",
            color = Color.Black,
            style = MaterialTheme.typography.bodyLarge,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(32.dp))

        // Botón "Ver agenda"
        Button(
            onClick = onViewAgendaClick,
            colors = ButtonDefaults.buttonColors(containerColor = Color.Red),
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Ver agenda", color = Color.White)
        }

        Spacer(modifier = Modifier.height(32.dp))

        // Lista de medicamentos filtrados
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(filteredMedicamentos) { medicamento ->
                Text(
                    text = medicamento.nombre,
                    modifier = Modifier
                        .padding(8.dp)
                        .fillMaxWidth(),
                    style = MaterialTheme.typography.bodyMedium,
                    textAlign = TextAlign.Start
                )
            }
        }

        Spacer(modifier = Modifier.height(32.dp))

        // Imagen debajo del botón
        Image(
            painter = painterResource(id = R.drawable.img_2), // Cambia el ID de la imagen si es necesario
            contentDescription = null,
            modifier = Modifier.size(200.dp)
        )
    }
}

// Función que maneja la búsqueda del medicamento
private fun buscarMedicamento(query: String) {
    // Aquí puedes implementar la lógica para buscar el medicamento
    // Este ejemplo solo imprime en la consola.
    if (query.isNotBlank()) {
        println("Buscando medicamento: $query") // Solo un ejemplo
    } else {
        println("Por favor, ingrese un medicamento para buscar.")
    }
}
