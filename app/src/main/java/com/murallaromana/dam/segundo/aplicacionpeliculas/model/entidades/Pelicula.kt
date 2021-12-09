package com.murallaromana.dam.segundo.aplicacionpeliculas.model.entidades

import java.io.Serializable

data class Pelicula (
    var titulo: String,
    var genero: String,
    var director: String,
    var nota: Double,
    var telefonoDirector: String,
    var URL: String,
    var resumen: String
):Serializable