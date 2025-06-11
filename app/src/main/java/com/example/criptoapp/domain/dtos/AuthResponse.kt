package com.example.criptoapp.domain.dtos

data class AuthResponse(
    val message : String,
    val userId : Int,
    val isLoggedIn : Boolean

)
