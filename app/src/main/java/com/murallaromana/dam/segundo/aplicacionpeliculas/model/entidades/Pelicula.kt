package com.murallaromana.dam.segundo.aplicacionpeliculas.model.entidades

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Pelicula(
    @SerializedName("title") var titulo: String,
    var genero: String,
    var director: String,
    var nota: Double,
    var telefonoDirector: String,
    var URL: String,
    var resumen: String
) : Serializable