class Empleado(nombre: String,rut: String,fechaNacimiento: String, edad: Int,val cargo: String, val sueldo: Int)
                : Persona(nombre,rut,fechaNacimiento,edad){

    override fun mostrarInfo(): String {
        return super.mostrarInfo() + "\nLa persona posee un cargo de: $cargo. Con un sueldo de: $$sueldo"
    }

    fun calcularBonificacion(){
        var bonificacion: Double? = null

        if (edad >= 45){
            bonificacion = sueldo * 0.12
            println("Por su edad, corresponde una bonificacion a su sueldo equivalente a: $$bonificacion.")
        } else {
            println("No cumple con los requisitos para la bonificacion por su edad.")
        }
    }

    override fun informar(): String {
        return "Ahora, este objeto es de tipo Empleado."
    }

    /*
    fun calcularBonificacion(): Double?{
        var bonificacion: Double? = null

        if (edad >= 45){
            bonificacion = sueldo * 0.12
            println("Por su edad, corresponde una bonificacion a su sueldo equivalente a: $$bonificacion.")
        } else {
            println("No cumple con los requisitos para la bonificacion por su edad.")
        }
    }
    */
}