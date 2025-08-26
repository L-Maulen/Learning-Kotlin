fun main() {
    /*
    // Creo un objeto de tipo Automovil
    val automovil = Automovil(marca = "Toyota", modelo = "Corolla", anio = 2024)

    println("------------ Automovil ------------")

    automovil.mostrarFichaTecnica()

    // Creo un objeto del tipo deportivo
    val deportivo = Deportivo(marca = "Lamborghini", modelo = "Huracan", anio = 2025, velocidadMaxima = 280)

    println("\n------------ Deportivo ------------")

    deportivo.mostrarFichaTecnica()
    deportivo.mostrarVelocidadMax()
    */


    // ACTIVIDAD 1 (paso 1)
    println("\n---------- Personas ----------")
    val persona1 = Persona("Luis","12445","80-78-901",34)
    val persona2 = Persona("Andres","00002","Ayer",2)
    val persona3 = Persona("Nico","9112","15/06/2002",24)

    println("\n--- Persona 1 ---")
    println(persona1.mostrarInfo())

    println("\n--- Persona 2 ---")
    println(persona2.mostrarInfo())

    println("\n--- Persona 3 ---")
    println(persona3.mostrarInfo())
    println("--------------------------------")

    println("\n-------- Empleados --------")
    val empleado1 = Empleado(nombre = "Leonel", rut = "2124312", fechaNacimiento = "098790", edad = 40, cargo = "Marketing Manager", sueldo = 12000000)
    println("\n--- Empleado 1 ---")
    println(empleado1.mostrarInfo())
    empleado1.calcularBonificacion()

    val empleado2 = Empleado(nombre = "Astrid", rut = "814981251435", fechaNacimiento = "99-24-1", edad = 24, cargo = "Jefa de Recursos Humanos", sueldo = 1500000)

    val listaPersonas = listOf(persona1, persona2, persona3, empleado1, empleado2)

    println("\n----------- Polimorfismo metodo informar ------------")

    for (e in listaPersonas){
        println( e.informar())
    }

}


