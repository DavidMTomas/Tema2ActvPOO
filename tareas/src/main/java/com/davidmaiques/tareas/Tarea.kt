package com.davidmaiques.tareas

import Prioridad

data class Tarea(
    var nombre: String,
    var descripcion: String,
    var prioridad: Prioridad,
    var completada: Boolean,
){

    override fun toString(): String {
        return "Tarea(nombre='$nombre', descripcion='$descripcion', prioridad=$prioridad, comopletada=$completada)"
    }
}
