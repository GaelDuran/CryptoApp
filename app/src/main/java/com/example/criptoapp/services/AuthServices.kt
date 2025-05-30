package com.example.criptoapp.services

import retrofit2.http.POST

interface AuthServices {

    @POST("login")
    fun login()

    @POST("register")
    fun register()

}