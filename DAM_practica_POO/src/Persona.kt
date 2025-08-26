open class Persona(val nombre: String, val rut: String, val fechaNacimiento: String, val edad: Int): Informable{

    open fun mostrarInfo():String{
        return "Nombre de la persona: $nombre \nRut de la persona: $rut \nFecha de nacimiento: $fechaNacimiento \nEdad: $edad"
    }

    override fun informar(): String {
        return "Confirmo que este objeto es una persona."
    }
}