// Aca se crearan las clases relacionadas a los libros

open class Libro(val titulo: String, val precio: Int, val autor: String){

    init {
        require(value = precio > 0){"El precio NO puede ser Negativo (-)."}
    }

    open fun detalle(): String = "$titulo de $autor - $$precio"

}


class LibroFisico(titulo:String,precio: Int, autor: String, val costoEnvio: Int): Libro(titulo,precio,autor) {

    override fun detalle(): String {
        return super.detalle() + " - Físico - Costo de envío:  + $$costoEnvio"
    }

    fun precioTotal(): Int = precio + costoEnvio

}


class LibroDigital(titulo:String, precio: Int, autor: String, val formato: String): Libro(titulo,precio,autor) {

    override fun detalle(): String {
        return super.detalle() + " - Digital - Formato: $formato"
    }
    

}