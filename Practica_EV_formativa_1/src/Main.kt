import kotlinx.coroutines.runBlocking

fun main() {
    val entradas = listOf(
        EntradaGeneral("G-001", 30, "Concierto Rock"),
        EntradaGeneral("G-002", 25, "Festival Gastronómico"),
        EntradaGeneral("G-003", 20, "Feria del Libro"),
        EntradaVip("V-001", 50, "Concierto Rock", "Acceso a backstage y barra libre"),
        EntradaVip("V-002", 45, "Festival Gastronómico", "Degustaciones exclusivas y área de descanso"),
        EntradaVip("V-003", 40, "Feria del Libro", "Meet & greet con autores y acceso prioritario"),
        EntradaGeneral("G-004", 22, "Orquesta Sinfonica")
    )

    println("--- Precio total de las entradas vendidas ---")
    println(calcularPrecio(entradas))

    println("\n--- Conteo de las entradas vendidas ---")
    println(filtroEntradas(entradas))
    println("\n--- ESTADO ENTRADAS ---\n")

    runBlocking {
        for (e in entradas){
            when(validarEntrada(e.id, entradas)){
                is EstadoValidacion.Valida -> println("Entrada con id: ${e.id} validada con exito.\n")
                else -> println("Error al validar la entrada")
            }

        }
    }


}

