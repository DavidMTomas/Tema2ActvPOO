package com.davidmaiques.tema2actvpoo

open class Libro(
    val titulo: String,
    val autor: String,
    val anyoPublicacion: Int,
    var precio: Double,
){

    open fun calcularPrecioDescuento(){
        var des=(precio * 0.20)
        var precioFinal=precio-des
        precio=Math.round(precioFinal*100)/100.0
    }

    override fun toString(): String {
        return "titulo='$titulo', autor='$autor', anyoPublicacion=$anyoPublicacion, precio=$precio "
    }


}