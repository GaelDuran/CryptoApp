package com.example.criptoapp.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    // String / AuthServices

    @Provides
    @Singleton
    fun providesATestingString(): String {
        return "Hola ando probando dagger hilt"
    }
}