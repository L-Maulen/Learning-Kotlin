import kotlinx.coroutines.delay

sealed class EstadoValidacion{
    object Validando: EstadoValidacion(){
        override fun toString(): String = "Validando entrada con id:"
    }

    data class Valida(val entrada: Entrada): EstadoValidacion(){
        override fun toString(): String = "Entrada validada\n ${entrada.mostrarDetalle()}"
    }

    data class NoValida(val mensajeError: String): EstadoValidacion(){
        override fun toString(): String = "Error: $mensajeError"
    }
}

suspend fun validarEntrada(id: String, listaEntradas: List<Entrada>): EstadoValidacion{
    var validacion: EstadoValidacion
    println(EstadoValidacion.Validando.toString() + id)

    delay(2000)

    for (e in listaEntradas){
        if (e.id == id){
            validacion = EstadoValidacion.Valida(e)
            return validacion
        }
    }

    validacion = EstadoValidacion.NoValida("No se encontro el id: $id")
    return validacion

}