package com.murallaromana.dam.segundo.aplicacionpeliculas.model.data

import com.murallaromana.dam.segundo.aplicacionpeliculas.model.entidades.Pelicula

interface PeliculasData {
    fun getTodos(): MutableList<Pelicula>
}