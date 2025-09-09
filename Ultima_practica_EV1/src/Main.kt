import kotlinx.coroutines.*

fun main(){
    val listaEntradasVendidas = mutableListOf(
        EntradaGeneral(
            id = 1,
            precio = 35000.0,
            nombreEvento = "TechJam",
            lugarEvento = "Estadio Centenario de la Innovación",
            accesoZona = "Cancha"
        ),
        EntradaVip(
            id = 2,
            precio = 95000.0,
            nombreEvento = "TechJam",
            lugarEvento = "Estadio Centenario de la Innovación",
            beneficiosExtra = "Backstage y barra libre"
        ),
        EntradaGeneral(
            id = 3,
            precio = 32000.0,
            nombreEvento = "TechJam",
            lugarEvento = "Estadio Centenario de la Innovación",
            accesoZona = ""
        ),
        EntradaVip(
            id = 4,
            precio = 120000.0,
            nombreEvento = "TechJam",
            lugarEvento = "Estadio Centenario de la Innovación",
            beneficiosExtra = ""
        ),
        EntradaGeneral(
            id = 5,
            precio = 10.0,
            nombreEvento = "TechJam",
            lugarEvento = "Estadio Centenario de la Innovación",
            accesoZona = "Grada"
        ),
        EntradaVip(
            id = 6,
            precio = 95000.0,
            nombreEvento = "OtroFest",
            lugarEvento = "Estadio Centenario de la Innovación",
            beneficiosExtra = "Backstage"
        ),
        EntradaGeneral(
            id = 7,
            precio = 35000.0,
            nombreEvento = "TechJam",
            lugarEvento = "Otro Estadio",
            accesoZona = "Cancha"

        ))


    var entradasValidas = mutableListOf<Entrada>()
    var entradasRechazadas = mutableListOf<Entrada>()

    runBlocking{
        for(e in listaEntradasVendidas){
            when(validarEntrada(e.id, listaEntradasVendidas)) {
                is EstadoValidacion.NoValida -> {
                    entradasRechazadas.add(e);
                    println("-- Entrada no valida --")
                }

                is EstadoValidacion.Valida -> {
                    entradasValidas.add(e);
                    println("-- Entrada valida --")
                }

                else -> {
                    println("Error brigido shaval")
                }
            }
        }
    }


    println("\n---- Listado entradas validas: -----\n")
    entradasValidas.forEach { println(it.mostrarDetalle()) }

    println("\n---- Listado entradas NO validas ----\n")
    entradasRechazadas.forEach { print(it.mostrarDetalle()) }

    println("\n--- Ingreso total entradas validas ---")
    println(ingresoTotal(entradasValidas))

    println("\n--- Cantidad entradas VIP validas ---")
    print(cantidadEntradasVip(entradasValidas))

}