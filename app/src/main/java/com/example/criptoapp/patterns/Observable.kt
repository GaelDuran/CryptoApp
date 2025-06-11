package com.example.criptoapp.patterns

import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.runBlocking

//FLUJOS AFUERZA CORRUTINA

fun main() {
    runBlocking {
        val flujo = flow {
            emit(1)
            emit(2)
            emit(3)
            emit(4)
        }

        flujo.collect{ value ->
            println("Recibi un mensaje: $value")
        }

        val flujo2 = flowOf(10,20,30,40)
        val list = listOf("Iniciando", "Cargando", "Terminado")
        val flow3 = list.asFlow()
    }
}