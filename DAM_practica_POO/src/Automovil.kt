open class Automovil (val marca: String, val modelo: String, val anio: Int){
    // Metodo abierto para que pueda ser sobreescrito
    open fun mostrarFichaTecnica() { // Funcion sin retorno
        println("Este es un automovil: $marca, su modelo es: $modelo del año: $anio.")
    }
}

// Clase derivada Deportivo que hereda de automovil
class Deportivo(marca: String, modelo: String, anio: Int, val velocidadMaxima: Int): Automovil(marca, modelo, anio){
// : Automovil(marca, modelo, anio) -> Le indico que hereda esos elementos de la clase Automovil

    fun mostrarVelocidadMax(){
        println("El $marca $modelo del año $anio, corre a una velocidad maxima de: $velocidadMaxima km/h")
    }

    //Polimorfismo (sobreescribir el metodo mostrarFichaTecnica()
    override fun mostrarFichaTecnica() {
        // super.mostrarFichaTecnica() -> Con este, muestra lo mismo que el metodo de la clase padre
            println("Este es un auto deportivo $marca $modelo del año $anio. Y su velocidad maxima es de $velocidadMaxima km/h")
    }
}
