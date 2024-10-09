package com.davidmaiques.tema2actvpoo

class LibroDigital(val formato:String,
                   titulo: String,
                   autor: String,
                   anyoPublicacion: Int,
                   precio: Double
): Libro(titulo, autor, anyoPublicacion, precio) {

    override fun calcularPrecioDescuento() {
        var des=(precio * 0.20)
        var precioFinal=precio-des
        precio=Math.round(precioFinal*100)/100.0
        println(precioFinal)
    }

    override fun toString(): String {
        return "${super.toString()}formato='$formato')"
    }


}