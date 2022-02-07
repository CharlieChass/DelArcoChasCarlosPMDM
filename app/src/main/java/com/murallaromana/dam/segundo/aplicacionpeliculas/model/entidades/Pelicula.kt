package com.murallaromana.dam.segundo.aplicacionpeliculas.model.entidades

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Pelicula(
    @SerializedName("title") var titulo: String,
    @SerializedName("genre")var genero: String,
    @SerializedName("directorFullname")var director: String,
    @SerializedName("rating")var nota: Double,
    @SerializedName("directorPhone")var telefonoDirector: String,
    @SerializedName("imageUrl")var URL: String,
    @SerializedName("description")var resumen: String
) : Serializable