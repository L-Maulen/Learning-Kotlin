import kotlinx.coroutines.*

fun ingresoTotal(entradasVendidas: List<Entrada>):Double{
    var ingresoTotal: Double = 0.0
    ingresoTotal = entradasVendidas.sumOf { it.precio }
    return ingresoTotal
}

fun cantidadEntradasVip(listaEntradas: List<Entrada>): Int{
    var cantidadEntradas: Int = 0

    for (e in listaEntradas){
        if (e is EntradaVip){
            cantidadEntradas ++
        }
    }

    return cantidadEntradas
}


suspend fun validarEntrada(id: Int, listaEntradas: List<Entrada>): EstadoValidacion{
    var validacionEntrada: EstadoValidacion
    val entrada = listaEntradas.find { it.id == id }
    val mensaje: String

    println("Iniciando proceso para validar la entrada con id: $id")

    validacionEntrada = EstadoValidacion.Validando

    delay(2000)

    if (entrada == null){
        mensaje = "No hay entrada con el ID dado."
        return  EstadoValidacion.NoValida(mensaje)
    }

    if (entrada.precio <= 0){
        mensaje = "El precio de la entrada debe ser mayor a 0"
        return  EstadoValidacion.NoValida(mensaje)

    } else if(entrada.nombreEvento.lowercase() != "techjam"){
        mensaje = "El nombre del evento debe ser 'TechJam'"
        return  EstadoValidacion.NoValida(mensaje)

    } else if(entrada.lugarEvento.lowercase() != "estadio centenario de la innovación"){
        mensaje = "El lugar del evento debe ser 'Estadio Centenario de la Innovación'"
        return  EstadoValidacion.NoValida(mensaje)

    } else if (entrada is EntradaGeneral && entrada.accesoZona.isEmpty()){
        mensaje = "Al ser entrada general, el acceso zona no debe estar vacio"
        return EstadoValidacion.NoValida(mensaje)

    } else if (entrada is EntradaVip && entrada.beneficiosExtra.isEmpty()){
        mensaje = "Al ser entrada VIP, beneficios extra no debe estar vacio"
        return EstadoValidacion.NoValida(mensaje)

    } else{
        return EstadoValidacion.Valida(entrada)
    }


}