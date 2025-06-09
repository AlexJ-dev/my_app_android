package com.example.practica_04

data class Pedido(val nombre: String, val especificacion: String, val cantidad: Int, val categoria: String)
data class MisPedidos(
    val numero: String,
    val mozo: String,
    val hora: String,
    val estado: String,
    val mesa: String
)

