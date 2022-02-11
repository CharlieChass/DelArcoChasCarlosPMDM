package com.murallaromana.dam.segundo.aplicacionpeliculas.utils

import android.content.Context
import androidx.appcompat.app.AlertDialog

class Alertas(val context: Context) {

    fun mostrarAlerta(title: String, mensaje: String) {
        val adb = AlertDialog.Builder(context)
        adb.setTitle(title)
        adb.setMessage(mensaje)
        adb.setPositiveButton("Aceptar", null)
        adb.show()
    }
}