// Hay que crear una clase sellada

sealed class EstadoPedido{
    object Pendiente : EstadoPedido(){
        override fun toString() = "Pendiente"
    }

    object EnProceso : EstadoPedido(){
        override fun toString() = "En Proceso"
    }

    object Listo : EstadoPedido(){
        override fun toString() = "Listo"
    }

    data class Error(val mensaje: String) : EstadoPedido(){
        override fun toString() = "Error: $mensaje"
    }
}
