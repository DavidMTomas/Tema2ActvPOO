package com.davidmaiques.tareas

import Prioridad
import java.util.Scanner


val sc = Scanner(System.`in`)
fun main() {
    try {
        val tareas: MutableList<Tarea> = mutableListOf()


        while (true) {
            when (mostrarMenu()) {
                1 -> nuevaTarea(tareas)
                2 -> modificarTarea(tareas)
                3 -> listarTareasPrioridad(tareas)
                0 -> break
                else -> println("Valor no valido")
            }

        }

        println("Terminado ejercicio de tareas")
    } catch (e: Exception) {
        println("No funciona, error vlaor introducido ")
    }
}

fun listarTareasPrioridad(tareas: MutableList<Tarea>) {
    sc.nextLine()
    println("Prioridad:  alta, media, baja")
    var eleccion = sc.nextLine().uppercase()

    if (tareas.size > 0)
        tareas.filter { it.prioridad.name == eleccion }.forEach { println(it) }
    else println("No hay valores que mostar")

}

fun listarTareas(list: MutableList<Tarea>) {
    for (i in 0 until list.size) {
        println(list[i].toString())
    }
}


fun modificarTarea(tareas: MutableList<Tarea>) {
    if (tareas.size == 0) {
        println("No hay tareas")
    } else {
        var contador = 0
        println("Elige la atarea a modificar")
        for (i in 0..tareas.size - 1) {
            println("Numero: ${i + 1} ${tareas[i].toString()}")
        }
        var modificar = sc.nextInt()
        sc.nextLine()
        println("Vamos a modificar la tarea: ${tareas[modificar - 1].toString()}")
        // sc.nextLine()
        val tarea = datos(2)
        if (tarea != null) {
            with(tareas[modificar - 1]) {
                nombre = tarea.nombre
                descripcion = tarea.descripcion
                prioridad = tarea.prioridad
                completada = tarea.completada
            }
            /*
            tareas[modificar - 1].nombre = tarea.nombre
            tareas[modificar - 1].descripcion = tarea.descripcion
            tareas[modificar - 1].prioridad = tarea.prioridad
            tareas[modificar - 1].comopletada = tarea.comopletada
            */
        }
        listarTareas(tareas)
    }
}

fun datos(opcion: Int): Tarea? {
    var tarea: Tarea? = null
    //sc.nextLine()
    println("Nombre")
    var nombre = sc.nextLine()

    println("Descripcion")
    var descripcion = sc.nextLine()

    println("prioridad: ALTA,MEDIA,BAJA")
    var prioridad = when (sc.nextLine().uppercase()) {
        "ALTA" -> Prioridad.ALTA
        "MEDIA" -> Prioridad.MEDIA
        "BAJA" -> Prioridad.BAJA
        else -> Prioridad.BAJA
    }

    println("Completada si // no")
    val completada = sc.nextLine().lowercase() == "si"

    if (opcion == 1) {
        tarea = Tarea(nombre, descripcion, prioridad, completada)
    } else if (opcion == 2) {

       tarea = Tarea(nombre, descripcion, prioridad, completada).apply {
            this.nombre = nombre
            this.descripcion = descripcion
            this.prioridad = prioridad
            this.completada = completada
        }

        /*
        tarea = Tarea(
            nombre = nombre,
            descripcion = descripcion,
            prioridad = prioridad,
            comopletada = completada
        )*/
    }

    return tarea
}

fun nuevaTarea(list: MutableList<Tarea>) {
    sc.nextLine()
    val tarea = datos(1)
    if (tarea != null) {
        agregarTarea(list, tarea)
    }
}

fun agregarTarea(list: MutableList<Tarea>, tarea: Tarea) {
    list.add(tarea)
    println("Lista agregada al listado")

    for (i in list) {
        println(i)
    }
}

fun mostrarMenu(): Int {
    val menu = """
        0.- Salir
        1.- Agregar Tarea
        2.- Modificar Tarea
        3.- Listar Tarea
    """.trimIndent()
    println(menu)
    return sc.nextInt()
}
