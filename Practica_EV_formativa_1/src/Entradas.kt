open class Entrada(val id: String,val precio: Int, val nombre: String) {

    open fun mostrarDetalle(): String = "Id entrada: $id - Precio Original: $precio"
}


class EntradaGeneral(id: String, precio: Int, nombre: String): Entrada(id,precio, nombre) {
    override fun mostrarDetalle(): String {
        return super.mostrarDetalle() + " - No posee beneficios"
    }
}

class EntradaVip(id: String, precio: Int,nombre: String, val beneficiosExtra: String): Entrada(id,precio,nombre) {

    override fun mostrarDetalle(): String {
        return super.mostrarDetalle() + " - Beneficios extra por ser VIP: $beneficiosExtra"
    }

}
