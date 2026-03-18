package com.example.logistica.entity

data class Usuarios (
    var idUsuario : Int = 0,
    var usuario : String = "",
    var contrasena : String = "",
    var nombreCompleto : String = "",
    var idRol : String = "",
    var activo : Int = 1,
    var fechaCreacion : String = ""
)