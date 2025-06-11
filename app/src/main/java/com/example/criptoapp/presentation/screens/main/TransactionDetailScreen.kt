package com.example.criptoapp.presentation.screens.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.criptoapp.presentation.theme.CriptoAppTheme

@Composable
fun TransactionDetailScreen() {
    Column(
        modifier = Modifier
            .background(Color.White)
            .padding(24.dp)
            .fillMaxSize()
    ) {
        Text(
            text = "Detalle de Transaccion",
            style = MaterialTheme.typography.headlineMedium
        )
        Spacer(modifier = Modifier.height(32.dp))
        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = MaterialTheme.shapes.medium,
            colors = androidx.compose.material3.CardDefaults.cardColors(
                containerColor = Color.White
            )
        ) {
            Column(
                modifier = Modifier
                    .background(Color.White)
                    .padding(24.dp)
            ) {
                Text(text = "Monto", style = MaterialTheme.typography.titleMedium)
                Text(
                    text = "₿0.00119920",
                    style = MaterialTheme.typography.headlineSmall,
                    color = Color(0xFFFF9800)
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(text = "Costo por BTC", style = MaterialTheme.typography.titleMedium)
                Text(
                    text = "$27,350.75",
                    style = MaterialTheme.typography.bodyLarge
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(text = "Total USD", style = MaterialTheme.typography.titleMedium)
                Text(
                    text = "$68.38",
                    style = MaterialTheme.typography.bodyLarge
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(text = "Tipo de Operacion", style = MaterialTheme.typography.titleMedium)
                Text(
                    text = "BTC recibido",
                    style = MaterialTheme.typography.bodyLarge,
                    color = Color(0xFF4CAF50)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TransactionDetailScreenPreview() {
    CriptoAppTheme {
        TransactionDetailScreen()
    }
}
