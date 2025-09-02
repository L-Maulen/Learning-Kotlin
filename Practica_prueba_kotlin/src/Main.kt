import kotlinx.coroutines.*

fun main() = runBlocking {
    println("=== SISTEMA BOOFAST ===")

    // Lista por defecto inmutable
    val catalogo = listOf(
        LibroFisico(titulo = "El Principito", precio = 8000, autor = "Antoine de Saint-Exupéry", costoEnvio = 2000),
        LibroDigital(titulo = "1984", precio = 5000, autor = "George Orwell", formato = "PDF"),
        LibroFisico(titulo = "Cien Años de Soledad", precio = 15000, autor = "Gabriel García Márquez", costoEnvio = 3000),
        LibroDigital(titulo = "Clean Code ", precio = 15000, autor = "Robert C. Martin", formato = "ePub")

    )

    val sistema = BookFast(catalogo)
    sistema.mostrarCatalogo()

    do {
        println("\nIngrese su seleccion [números separados por coma (,)]: ")
        // readLine es como el input()
        val seleccion = readLine()?.split(",")?.
        map { it.trim().toInt() } ?: emptyList()

    } while(!sistema.agregarAlCarrito(seleccion))

    println("Cliente tipo [regular/vip/premium]: ")

    val cliente = Cliente.fromString(readLine()!!) ?:
    Cliente(tipo = "Regular", descuento = 0.05)

    sistema.procesarPedido(cliente)

}