open class Entrada( val id: Int,
                    val precio: Double,
                    val nombreEvento: String,
                    val lugarEvento: String){

    init {
        require(precio > 0){"El precio debe ser mayor a 0"}
    }

    open fun mostrarDetalle(): String{
        return "---- Informacion Entrada ----\n" +
                "Id: $id\n" +
                "Precio: $$precio\n" +
                "Nombre evento: $nombreEvento\n" +
                "Lugar evento: $lugarEvento"
    }
}

class EntradaGeneral(id: Int,
                     precio: Double,
                     nombreEvento: String,
                     lugarEvento: String,
                     val accesoZona: String): Entrada(id,precio,nombreEvento,lugarEvento){

    override fun mostrarDetalle(): String {
        return super.mostrarDetalle() + "\n-- Entrada General --" +
                "Acceso zona: $accesoZona"
    }
}

class EntradaVip(id: Int,
                     precio: Double,
                     nombreEvento: String,
                     lugarEvento: String,
                     val beneficiosExtra: String): Entrada(id,precio,nombreEvento,lugarEvento){

    override fun mostrarDetalle(): String {
        return super.mostrarDetalle() + "\n-- Entrada VIP --" +
                "Beneficios extra: $beneficiosExtra"
    }
}