package com.davidmaiques.tema2actvpoo

fun main() {
    val libro=Libro("titulo","autor",2024,25.36)
    val libro2=LibroDigital("pdf","titulo","autor",2024,25.36)

    println(libro)
    libro.calcularPrecioDescuento()
    println(libro)

    println(libro2)
    libro2.calcularPrecioDescuento()
    println(libro2)
}