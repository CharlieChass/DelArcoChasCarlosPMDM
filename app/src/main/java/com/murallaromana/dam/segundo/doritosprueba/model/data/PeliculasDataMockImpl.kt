package com.murallaromana.dam.segundo.doritosprueba.model.data

import com.murallaromana.dam.segundo.doritosprueba.model.entidades.Pelicula

class PeliculasDataMockImpl : PeliculasData {
    override fun getTodos(): List<Pelicula> = listOf(
            Pelicula("Titulo de Pelicula","Miedo","Director",7.8,""),
            Pelicula("Titulo de Pelicula","Miedo","Director",7.8,""),
            Pelicula("Titulo de Pelicula","Miedo","Director",7.8,""),
            Pelicula("Titulo de Pelicula","Miedo","Director",7.8,"")
    )
}