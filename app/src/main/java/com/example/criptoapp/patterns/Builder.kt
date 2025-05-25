package com.example.criptoapp.patterns

// Builder
// Retrofit.Builder().baseURL(")
// Retrofit(baseUrl = "")

class Usuario private constructor (
    val nombre: String,
    val edad : Int,
    val correo : String
) {
    class Builder {
        private var nombre: String = ""
        private var edad: Int = 0
        private var correo: String = ""

        fun agregarNombre(nombre: String) = apply {this.nombre = nombre}


        fun agregarEdad(edad: Int) = apply {this.edad = edad}

        fun agregarCorreo(correo: String) = apply {this.correo = correo}

        fun build(): Usuario {
            return Usuario(nombre, edad, correo)
        }
    }
}

fun main() {
    val usuario = Usuario.Builder()
        .agregarNombre("Gael")
        .agregarEdad(21)
        .agregarCorreo("Mariguapo69")
        .build()
}