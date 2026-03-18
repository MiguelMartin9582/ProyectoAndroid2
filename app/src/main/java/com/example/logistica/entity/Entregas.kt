package com.example.logistica.entity

data class Entregas (
    var idEntrega : Int =0,
    var idPedido : Int =0,
    var idUsuario : Int =0,
    var fechaEntrega : String = "",
    var estado : String = "",
    var observacion : String = ""
)