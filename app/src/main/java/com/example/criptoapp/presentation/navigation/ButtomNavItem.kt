package com.example.criptoapp.presentation.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.criptoapp.presentation.components.Chart

sealed class ButtomNavItem(val title : String, val icon: ImageVector) {
    object Home : ButtomNavItem(title = "Inicio", icon = Icons.Default.Home)
    object Stats : ButtomNavItem(title = "Estadísticas", icon = Chart)
}

