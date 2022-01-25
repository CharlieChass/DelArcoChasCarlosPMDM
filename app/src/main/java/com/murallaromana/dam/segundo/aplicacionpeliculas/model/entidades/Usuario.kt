package com.murallaromana.dam.segundo.aplicacionpeliculas.model.entidades

import com.google.gson.annotations.SerializedName

class Usuario (
    var id: Int?,
    var correo: String,
    @SerializedName("password") var contraseña: String
    )
