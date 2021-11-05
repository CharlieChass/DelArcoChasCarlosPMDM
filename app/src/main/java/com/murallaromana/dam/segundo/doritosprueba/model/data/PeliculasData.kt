package com.murallaromana.dam.segundo.doritosprueba.model.data

import com.murallaromana.dam.segundo.doritosprueba.model.entidades.Pelicula

interface PeliculasData {
    fun getTodos(): List<Pelicula>
}