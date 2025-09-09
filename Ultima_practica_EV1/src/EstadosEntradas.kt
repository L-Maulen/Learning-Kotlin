sealed class EstadoValidacion(){
    object Validando: EstadoValidacion(){
        override fun toString(): String {
            return "Validando entrada ..."
        }
    }

    data class Valida(val entrada: Entrada): EstadoValidacion(){
        override fun toString(): String {
            return "Entrada validada.\n ${entrada.mostrarDetalle()}"
        }
    }

    data class NoValida(val mensajeError: String): EstadoValidacion(){
        override fun toString(): String {
            return "Error al validar la entrada.\n${mensajeError}"
        }
    }

}