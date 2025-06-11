package com.example.criptoapp.presentation.screens.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.criptoapp.domain.models.Transaction
import com.example.criptoapp.presentation.components.TransactionItem
import com.example.criptoapp.presentation.theme.CriptoAppTheme

@Composable
fun TransactionsScreen(innerPadding : PaddingValues){
    val transactions = listOf(
        Transaction(id = 1, userId = 101, amount = 0.05, date = "2025-06-10", type = 1),
        Transaction(id = 2, userId = 102, amount = 0.02, date = "2025-06-09", type = 0),
        Transaction(id = 3, userId = 103, amount = 0.1, date = "2025-06-08", type = 1),
        Transaction(id = 4, userId = 104, amount = 0.03, date = "2025-06-07", type = 0),
        Transaction(id = 5, userId = 105, amount = 0.07, date = "2025-06-06", type = 1)
    )
    Column(
        modifier = Modifier.fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(innerPadding)
            .padding(24.dp)
    ) {
        Text(
            text = "Transacciones",
            style = MaterialTheme.typography.headlineMedium
        )
        Box(
            modifier = Modifier.fillMaxWidth()
                .clip(RoundedCornerShape(size = 20.dp))
                .background(MaterialTheme.colorScheme.primary)
                .height(100.dp),
            contentAlignment = Alignment.Center
        ){
            Text(
                text = "₿ 0.000123",
                color = Color.White,
                style = MaterialTheme.typography.titleLarge
            )
        }
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(transactions) { it ->
                TransactionItem(
                    amount = it.amount,
                    date = it.date,
                    type = it.type
                )
            }
        }
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun TransactionsScreenPreview(){
    CriptoAppTheme {
        TransactionsScreen(innerPadding = PaddingValues(10.dp))
    }
}