package com.example.criptoapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.criptoapp.presentation.screens.LoginScreen
import com.example.criptoapp.presentation.theme.CriptoAppTheme
import kotlinx.serialization.Serializable

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CriptoAppTheme {
                val NavController = rememberNavController()
                NavHost(navController = NavController, startDestination = LoginScreenRoute){
                    composable<LoginScreenRoute> {
                        LoginScreen()
                    }
                }
            }
        }
    }
}


@Serializable
object LoginScreenRoute
