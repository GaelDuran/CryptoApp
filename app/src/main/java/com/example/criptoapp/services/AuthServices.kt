package com.example.criptoapp.services

import com.example.criptoapp.domain.dtos.BodyResponse
import com.example.criptoapp.domain.models.Auth
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthServices {
    @POST("login")
    suspend fun login(@Body auth: Auth) : BodyResponse

    @POST("register")
    suspend fun register(@Body auth: Auth) : BodyResponse
}