package com.example.logistica

data class Pedido(
    val id: String,
    val nombreCliente: String,
    val direccion: String,
    val descripcionPaquete: String,
    val prioridad: Int
)
