package com.example.criptoapp.presentation.screens.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.criptoapp.presentation.theme.CriptoAppTheme

@Composable
fun HomeScreen(innerPadding: PaddingValues){
    Column(
        modifier = Modifier
            .background(Color.Red)
            .padding(innerPadding)
            .fillMaxSize()
    ) {

    }

}

@Preview
@Composable
fun HomeScreenPreview(){
    CriptoAppTheme {
        HomeScreen(innerPadding = PaddingValues(10.dp))
    }
}
