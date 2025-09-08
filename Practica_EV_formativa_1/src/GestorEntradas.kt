fun calcularPrecio(listaEntradas: List<Entrada>): Int{

    try {
        var totalEntradas: Int

        totalEntradas = listaEntradas.sumOf { it.precio }

        return totalEntradas
    } catch (e: Exception){
        println("Ocurrio un error!! nia")
        return 0
    }

}

fun filtroEntradas(listaEntradas: List<Entrada>): String{
    var conteoVip: Int = 0
    var conteoGeneral: Int = 0

    listaEntradas.forEach { if(it is EntradaGeneral) conteoGeneral += 1 else conteoVip += 1}

    return "Entradas Generales vendidad:$conteoGeneral\nEntradas VIP venidas: $conteoVip"

}

