import kotlinx.coroutines.*


data class Cliente(val tipo: String, val descuento: Double){
    companion object{

        // Funcion para obtener el tipo de cliente y su descuento
        fun fromString(tipo: String): Cliente? = when(tipo.lowercase()){
            "regular" -> Cliente(tipo = "Regular", descuento = 0.05)
            "vip" -> Cliente(tipo = "VIP", descuento = 0.10)
            "premium" -> Cliente(tipo = "Premium", descuento = 0.15)
            else -> null
        }
    }
}
    // CLase que recibe el catalogo (que es una lista)
class BookFast(private val catalogo: List<Libro>){
    private val carrito = mutableListOf<Libro>()

        // MOstrar todos los libros que tengo
    fun mostrarCatalogo(){
        println("Catálogo disponible:\n")

        catalogo.forEachIndexed { index, libro ->
            println("${index + 1} .- ${libro.detalle()}")
        }
    }

        // Traigo una lista de numeros de los libros que quiero agregar
    fun agregarAlCarrito(indices: List<Int>): Boolean{
        try {
            for (i in indices){
                if (i in 1 .. catalogo.size){
                    carrito.add(catalogo[i - 1])
                } else{
                    throw IllegalArgumentException("Seleccion fuera del catálogo.")
                }
            }
        } catch (e: Exception){
            var estado: EstadoPedido
            estado = EstadoPedido.Error(e.message ?: "Error desconocido.")
            println("UPPPZZZ!! Ocurrio un error: ${(estado as EstadoPedido.Error).mensaje}")
            return false
        }
        return true
    }

    private fun calcularSubtotal(): Int =
        carrito.sumOf{ if (it is LibroFisico) it.precioTotal() else it.precio }

        suspend fun procesarPedido(cliente: Cliente){
            var estado: EstadoPedido = EstadoPedido.Pendiente
            println("\nProcesando: $estado ...")
            estado = EstadoPedido.EnProceso

            println("Estado: $estado ...")

            delay(timeMillis = 2000)

            try {
                val subtotal = calcularSubtotal()
                val descuento = (calcularSubtotal() * cliente.descuento).toInt()
                val iva = ((subtotal - descuento) * 0.19).toInt()

                val total = (subtotal - descuento + iva).toInt()

                estado = EstadoPedido.Listo

                println("\n=== RESUMEN DEL PEDIDO ===")
                println("-- Carrito --")
                carrito.forEach { println("- ${it.detalle()}") }
                println("Subtotal: $$subtotal")
                println("Descuento: ${cliente.tipo} - $$descuento")
                println("IVA: $$iva")
                println("Total: $$total")
                println("Estado Final: $estado")

            } catch (e: Exception){
                estado = EstadoPedido.Error(e.message?: "Error desconocido")
                println("Ocurrio un error: ${(estado as EstadoPedido.Error).mensaje}")
            }

        }


}

