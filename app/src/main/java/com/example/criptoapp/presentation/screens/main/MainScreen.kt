package com.example.criptoapp.presentation.screens.main

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.criptoapp.presentation.theme.CriptoAppTheme

@Composable
fun MainScreen(){
    Text("Hola")

}

@Preview
@Composable
fun MainScreenPreview(){
    CriptoAppTheme {
        MainScreen()
    }
}