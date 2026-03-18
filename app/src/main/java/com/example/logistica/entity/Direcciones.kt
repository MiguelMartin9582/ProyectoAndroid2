package com.example.logistica.entity

data class Direcciones (
    var IdDireccion : Int =0,
    var IdCliente : Int =0,
    var Direccion : String="",
    var Ciudad : String="",
    var Referencia : String="",
    var Latitud : Double=0.0,
    var Longitud : Double=0.0,
)