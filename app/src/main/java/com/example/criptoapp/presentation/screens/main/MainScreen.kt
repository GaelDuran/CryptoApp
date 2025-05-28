package com.example.criptoapp.presentation.screens.main

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.criptoapp.presentation.navigation.HomeScreenRoute
import com.example.criptoapp.presentation.theme.CriptoAppTheme

@Composable
fun MainScreen(){
    val navController = rememberNavController()
    Scaffold(
        modifier = Modifier.fillMaxSize()
    ) { innerPadding ->
        NavHost(navController = navController, startDestination = HomeScreenRoute){
            composable <HomeScreenRoute> {
                HomeScreen(innerPadding = innerPadding)
            }

        }

    }

}

@Preview
@Composable
fun MainScreenPreview(){
    CriptoAppTheme {
        MainScreen()
    }
}