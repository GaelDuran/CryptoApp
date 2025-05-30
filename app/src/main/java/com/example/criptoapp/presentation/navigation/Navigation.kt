package com.example.criptoapp.presentation.navigation

import kotlinx.serialization.Serializable

sealed class Screens () {
    @Serializable
    object LoginScreenRoute : Screens()

    @Serializable
    object RegisterScreenRoute : Screens()

    @Serializable
    object MainScreenRoute : Screens()

    @Serializable
    object MainGraph : Screens()

    @Serializable
    object HomeScreenRoute : Screens()

    @Serializable
    object StatsScreenRoute : Screens()
}