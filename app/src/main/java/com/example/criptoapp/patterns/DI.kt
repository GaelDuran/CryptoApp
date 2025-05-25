package com.example.criptoapp.patterns

// Construir una clase con sus subclases para funciones
class Procesador(val marca: String)

class MotherBoard(val marca: String)

class Storage(val gb: Double)

class SSD(val gb: Double) : IStorage

class HDD(val gb: Double) : IStorage

interface IStorage{


}

class Computer(val procesador: Procesador, val mb: MotherBoard, val storage: IStorage){

    fun enceder(){
        println("Encendiendo...")
    }
}
// DAGGER HILT

fun main(){
    val computer = Computer(
        procesador = Procesador(marca = "Intel"),
        mb = MotherBoard(marca = "Asus"),
        storage = SSD(gb = 50.0)
    )
}

// Principios SOLID

// Principio de Inversion de Dependencias
// Tuuuuu debes depender de abstracciones y no de construcciones

// Inyeccion de Dependencias Ejercicio
interface IMotor{
    fun encender()
}

class Motor(val hp: Double) : IMotor {
    override fun encender() {
        TODO("Not yet implemented")
    }
}

class MotorElectrico (val hp: Double) : IMotor {
    override fun encender() {
        TODO("Not yet implemented")
    }
}

class MotorHibrido(val hp: Double) : IMotor {
    override fun encender() {
        TODO("Not yet implemented")
    }
}

class Car(val motor: Motor, val puertas : Int)