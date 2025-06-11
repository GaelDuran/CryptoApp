package com.example.criptoapp.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.criptoapp.presentation.theme.CriptoAppTheme

@Composable
fun TransactionItem(amount:Double, type: Int, date: String) {
    val green  = Color(0xFF4CAF50)
    val red = Color(0xFFF44336)
    val colorCondition = if (type == 1) green else red
    val icon = if (type == 1) Icons.Default.KeyboardArrowUp else Icons.Default.KeyboardArrowDown
    val title = if (type == 1) "BTC recibido" else "BTC retirado"

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp)
            .padding(top = 12.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        // Icono
        Box(
            modifier = Modifier
                .padding(end = 10.dp)
                .size(30.dp)
                .clip(CircleShape)
            .background(colorCondition.copy(alpha = 0.2f)),
            contentAlignment = Alignment.Center
        ){
            Icon(
                imageVector = icon,
                contentDescription = null,
                tint = colorCondition

            )

        }

        // Info
        Column(
            modifier = Modifier
                .weight(1f)
        ) {
            Text(
                text = title,
                style = MaterialTheme.typography.bodyLarge,

            )
            Text(
                text = date,
                style = MaterialTheme.typography.bodySmall,
                color = Color.Gray
            )
        }
        // Precio
        Text(
            text = "₿ ${amount.toString()}",
            style = MaterialTheme.typography.titleSmall,
            color = colorCondition
        )

    }

}

@Preview
@Composable
fun TransactionItemPreview() {
    CriptoAppTheme{
        TransactionItem(
            amount = 0.02,
            type = 0,
            date = "2025-06-10"
        )
    }
}