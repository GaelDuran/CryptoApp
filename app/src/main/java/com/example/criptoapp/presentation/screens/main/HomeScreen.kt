package com.example.criptoapp.presentation.screens.main

import androidx.compose.foundation.Image
import com.example.criptoapp.R
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.criptoapp.domain.models.Transaction
import com.example.criptoapp.presentation.components.TransactionItem
import com.example.criptoapp.presentation.theme.CriptoAppTheme

@Composable
fun HomeScreen(innerPadding: PaddingValues){
    val latestTransaction = listOf(
        Transaction(id = 1, userId = 101, amount = 0.05, date = "2025-06-10", type = 1),
        Transaction(id = 2, userId = 102, amount = 0.02, date = "2025-06-09", type = 0),
        Transaction(id = 3, userId = 103, amount = 0.1, date = "2025-06-08", type = 1),
        Transaction(id = 4, userId = 104, amount = 0.03, date = "2025-06-07", type = 0),
        Transaction(id = 5, userId = 105, amount = 0.07, date = "2025-06-06", type = 1)
    )

    Column(
        modifier = Modifier
            .background(MaterialTheme.colorScheme.background)
            .padding(innerPadding)
            .padding(16.dp)
            .fillMaxSize()
    ) {
        // Header
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween

        ){
            // Column con saludo
            Column{
                Text(
                    text = "¡Bienvenido de nuevo!",
                    color = MaterialTheme.colorScheme.onBackground,
                    style = MaterialTheme.typography.bodyLarge
                )
                Text(
                    text = "Gael Durán",
                    color = MaterialTheme.colorScheme.primary,
                    style = MaterialTheme.typography.titleLarge
                )
            }
            // Icono
            IconButton(
                onClick = {}
            ) {
                Icon(
                    imageVector = Icons.Default.Settings,
                    contentDescription = null
                )
            }
        }

        //Bitcoin Price Card
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.surface
            )
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(R.drawable.bitcoin_logo),
                    contentDescription = null,
                    modifier = Modifier.size(50.dp),
                    contentScale = ContentScale.Crop
                )
                Text(
                    text = "$108,898 USD",
                    color = MaterialTheme.colorScheme.primary,
                    style = MaterialTheme.typography.titleSmall
                )
            }
        }
        Spacer(modifier = Modifier.height(20.dp))
        // Card de la Wallet
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.primary
            )
        ) {
            Column(
                verticalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(20.dp)
            ) {
                Text(
                    text = "Bitcoin Wallet",
                    color = MaterialTheme.colorScheme.onPrimary,
                    style = MaterialTheme.typography.bodyLarge
                    )
                Text(
                    text = "₿0.54",
                    color = MaterialTheme.colorScheme.onPrimary,
                    style = MaterialTheme.typography.headlineMedium
                )
                Text(
                    text = "$ 50,000.00 USD",
                    color = MaterialTheme.colorScheme.onPrimary,
                    style = MaterialTheme.typography.bodyLarge

                )
            }
        }

        // Botones de Accion
        Row(
            modifier = Modifier.padding(top = 16.dp)
                .fillMaxWidth(),
        ) {
            Button(
                onClick = {},
                modifier = Modifier.weight(1f)
                    .height(50.dp)
            ) {
                Text(text = "Agregar")
            }
            Spacer(modifier = Modifier.width(10.dp))
            OutlinedButton(
                onClick = {},
                modifier = Modifier.weight(1f)
                    .height(50.dp)
            ) {
                Text(text = "Retirar")
            }
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Text(
                text = "Ultimos movimientos",
                style = MaterialTheme.typography.titleMedium,
            )
            Text(
                text = "Ver todos",
                color = MaterialTheme.colorScheme.primary
            )
        }
        // Ultimos movimientos
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
        ) {
            items(latestTransaction) {
                TransactionItem(
                    amount = it.amount,
                    date = it.date,
                    type = it.type
                )
            }
        }
    }
}

@Preview
@Composable
fun HomeScreenPreview(){
    CriptoAppTheme {
        HomeScreen(innerPadding = PaddingValues(10.dp))
    }
}
