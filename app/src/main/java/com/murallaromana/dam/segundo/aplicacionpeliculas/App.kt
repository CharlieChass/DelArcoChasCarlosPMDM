package com.murallaromana.dam.segundo.aplicacionpeliculas

import android.app.Application
import com.murallaromana.dam.segundo.aplicacionpeliculas.model.data.PeliculasDataMockImpl
import com.murallaromana.dam.segundo.aplicacionpeliculas.model.entidades.Pelicula

class App: Application() {

    companion object{
        var peliculas: MutableList<Pelicula> = ArrayList()
    }

    override fun onCreate() {
        super.onCreate()
        val data = PeliculasDataMockImpl()
        peliculas = data.getTodos()
    }
}