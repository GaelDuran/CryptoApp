package com.example.criptoapp.patterns

//// Clase que solo gestiona usuarios
//class User(val name: String, val email: String)
//
//// Clase que solo maneja la lógica de guardar en base de datos
//class UserRepository {
//    fun save(user: User) {
//        println("Usuario ${user.name} guardado en la base de datos")
//    }
//}
//
//fun main() {
//    val user = User("Gael", "gael@email.com")
//    val repository = UserRepository()
//    repository.save(user)
//}

// Abierto a extensión mediante polimorfismo
//interface Descuento {
//    fun aplicar(total: Double): Double
//}
//
//class DescuentoNavidad : Descuento {
//    override fun aplicar(total: Double) = total * 0.8
//}
//
//class DescuentoLealtad : Descuento {
//    override fun aplicar(total: Double) = total * 0.9
//}
//
//class Carrito(val descuento: Descuento) {
//    fun calcularTotal(total: Double): Double = descuento.aplicar(total)
//}
//
//fun main() {
//    val totalCompra = 100.0
//
//    val carritoNavidad = Carrito(DescuentoNavidad())
//    println("Total con descuento de Navidad: ${carritoNavidad.calcularTotal(totalCompra)}")
//
//    val carritoLealtad = Carrito(DescuentoLealtad())
//    println("Total con descuento de Lealtad: ${carritoLealtad.calcularTotal(totalCompra)}")
//}

//open class Ave {
//    open fun volar() {
//        println("Volando...")
//    }
//}
//
//class Gorrion : Ave() {
//    override fun volar() {
//        println("El gorrión vuela")
//    }
//}
//
//class Pinguino : Ave() {
//     override fun volar() {
//         throw UnsupportedOperationException("El pingüino no vuela")
//     }
//}
//
//fun main() {
//    val gorrion = Gorrion()
//    gorrion.volar()
//
//    val pinguino = Pinguino()
//    pinguino.volar()
//}

//interface Imprimible {
//    fun imprimir()
//}
//
//interface Escaneable {
//    fun escanear()
//}
//
//class ImpresoraBasica : Imprimible {
//    override fun imprimir() {
//        println("Imprimiendo...")
//    }
//}
//
//fun main() {
//    val impresora = ImpresoraBasica()
//    impresora.imprimir()
//}

//interface Notificador {
//    fun enviar(mensaje: String)
//}
//
//class EmailNotificador : Notificador {
//    override fun enviar(mensaje: String) {
//        println("Enviando correo: $mensaje")
//    }
//}
//
//class ServicioUsuario(val notificador: Notificador) {
//    fun registrar(nombre: String) {
//        println("Usuario $nombre registrado")
//        notificador.enviar("Bienvenido $nombre")
//    }
//}
//
//fun main() {
//    val notificador = EmailNotificador()
//    val servicio = ServicioUsuario(notificador)
//    servicio.registrar("Gael")
//}

