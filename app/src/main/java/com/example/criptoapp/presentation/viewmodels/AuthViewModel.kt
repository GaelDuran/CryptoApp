package com.example.criptoapp.presentation.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.criptoapp.domain.models.Auth
import com.example.criptoapp.services.AuthServices
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch

@HiltViewModel
class AuthViewModel @Inject constructor(
    private val authServices: AuthServices
) : ViewModel(){

    // success LiveData
    private val _registerEvent = MutableSharedFlow<String>()
    val registerEvent = _registerEvent.asSharedFlow()

    fun login(email: String, password: String) {
        val auth = Auth(email = email, password = password)
        viewModelScope.launch {
            val response = authServices.login(auth)
            Log.i("AuthViewModel", response.toString())
        }
    }

    fun register(email: String, password: String) {
        val auth = Auth(email = email, password = password)
        viewModelScope.launch {
            val response = authServices.register(auth)
            Log.i("AuthViewModel", response.toString())
            if (response.body.isLoggedIn){
                // Que se regristro correctamente
                _registerEvent.emit("Success")
            }
            else {
                // Hubo un error
                _registerEvent.emit(response.messageContent)
            }
        }
    }
}