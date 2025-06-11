package com.example.criptoapp.presentation.screens.auth

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.criptoapp.R
import com.example.criptoapp.presentation.components.Visibility
import com.example.criptoapp.presentation.components.Visibility_off
import com.example.criptoapp.presentation.navigation.Screens
import com.example.criptoapp.presentation.theme.CriptoAppTheme
import com.example.criptoapp.presentation.viewmodels.AuthViewModel

@Composable
fun RegisterScreen(innerPadding: PaddingValues, navController : NavController) {

    val viewModel : AuthViewModel = hiltViewModel()

    var email by remember {
        mutableStateOf("")
    }

    var confirmPassword by remember {
        mutableStateOf("")
    }

    var password by remember {
        mutableStateOf("")
    }

    var isPasswordVisible by remember {
        mutableStateOf(false)
    }
    var isConfirmPasswordVisible by remember {
        mutableStateOf(false)
    }

    var showErrorDialog by remember {
        mutableStateOf(false)
    }

    var errorMessage by remember {
        mutableStateOf("")
    }

    LaunchedEffect(key1 = true) {
        viewModel.registerEvent.collect { result ->
            Log.i("RegisterScreen", "Recibiendo datillo $result")
            if(result != "Success"){
                // Ocurrio un error
                showErrorDialog =  true
                errorMessage = result
            }
            else {
                // Que todo esta bien, vamos a navegar al home
                navController.navigate(Screens.MainScreenRoute){
                    popUpTo(Screens.RegisterScreenRoute){ inclusive = true }
                }
            }
        }
    }
    if (showErrorDialog){
        AlertDialog(
            onDismissRequest = { showErrorDialog = false },
            confirmButton = {
                TextButton(onClick = { showErrorDialog = false }) {
                    Text(text = "Aceptar")
                }
            },
            title = { Text(text = "Error") },
            text = { Text(text = errorMessage) }
        )
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Texto dle Titulo
        Text(
            text = stringResource(R.string.app_name),
            style = MaterialTheme.typography.displaySmall,
            color = MaterialTheme.colorScheme.primary,
            fontWeight = FontWeight.Bold,
            letterSpacing = 3.sp
        )
        // Imagen
        Image(
            painter = painterResource(R.drawable.crypto3),
            contentDescription = "Login",
            modifier = Modifier.size(250.dp),
            contentScale = ContentScale.Crop
        )
        // Textfield Correo
        OutlinedTextField(
            value = email,
            onValueChange = { email = it},
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Email,
                    contentDescription = "email"
                )
            },
            placeholder = { Text (text = "Correo Electronico") },
            shape = RoundedCornerShape(20.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
        )
        // Textfield Contreseña
        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Lock,
                    contentDescription = "contraseña"
                )
            },
            trailingIcon = {
                Icon(
                    imageVector = if(isPasswordVisible) Visibility_off
                    else Visibility,
                    contentDescription = "contraseña",
                    modifier = Modifier.clickable {
                        isPasswordVisible = !isPasswordVisible
                    }
                )
            },
            placeholder = { Text (text = "Contraseña") },
            shape = RoundedCornerShape(20.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
            visualTransformation = if (isPasswordVisible) VisualTransformation.None
            else PasswordVisualTransformation()
        )
        // Textfield Contreseña
        OutlinedTextField(
            value = confirmPassword,
            onValueChange = { confirmPassword = it },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Lock,
                    contentDescription = "contraseña"
                )
            },
            trailingIcon = {
                Icon(
                    imageVector = if(isConfirmPasswordVisible) Visibility_off
                    else Visibility,
                    contentDescription = "contraseña",
                    modifier = Modifier.clickable {
                        isConfirmPasswordVisible = !isConfirmPasswordVisible
                    }
                )
            },
            placeholder = { Text (text = "Confirmar contraseña") },
            shape = RoundedCornerShape(20.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
            visualTransformation = if (isPasswordVisible) VisualTransformation.None
            else PasswordVisualTransformation()
        )
        
        if(confirmPassword.isEmpty() && (password != confirmPassword)){
            Text(
                text = "Las contraseñas no coinciden",
                color = Color.Red,
                style = MaterialTheme.typography.bodyLarge
            )
        }

        //Boton de registrar
        Button(
            onClick = {
                viewModel.register(email = email, password = password)
            },
            enabled = (password == confirmPassword)
                    && email.isNotBlank()
                    && password.isNotBlank()
                    && confirmPassword.isNotBlank(),
            modifier = Modifier
                .padding(bottom = 16.dp, top = 20.dp)
                .fillMaxWidth()
                .height(40.dp)

        ) {
            Text(
                text = "Registrarse"
            )
        }
    }
}

@Preview
@Composable
fun RegisterScreenPreview() {
    CriptoAppTheme {
        RegisterScreen(innerPadding = PaddingValues(10.dp), navController = rememberNavController())
    }
}