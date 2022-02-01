package com.murallaromana.dam.segundo.aplicacionpeliculas.model.data

import android.content.Context

class Preferences (
    val context: Context
        ) {
    val nombreArchivo = "BaseDatos"

    val Pref = context.getSharedPreferences(nombreArchivo,0)

    fun guardar(token: String){
            Pref.edit().putString("token",token).commit()
        }
}
