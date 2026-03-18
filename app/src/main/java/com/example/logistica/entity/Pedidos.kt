package com.example.logistica.entity

data class Pedidos (
    var idPedido : Int =0,
    var codigo : String = "",
    var descripcion : String = "",
    var cantidadPaquetes : Int =0,
    var prioridad : Int =0,
    var fechaRegistro : String = "",
    var idCliente : Int =0,
    var idDireccion : Int =0,
    var idEstado : Int =0
)