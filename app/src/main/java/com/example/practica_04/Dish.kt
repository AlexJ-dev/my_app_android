package com.example.practica_04

data class Dish(
    val name: String,      // Nombre del plato
    val price: Double,     // Precio del plato
    val category: String,  // Categoría a la que pertenece
    val imageResId: Int    // Referencia a la imagen del plato (Drawable)
)
