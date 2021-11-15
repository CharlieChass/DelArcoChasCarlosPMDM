package com.murallaromana.dam.segundo.doritosprueba.model.data

import com.murallaromana.dam.segundo.doritosprueba.model.entidades.Pelicula

class PeliculasDataMockImpl : PeliculasData {
    override fun getTodos(): List<Pelicula> = listOf(
            Pelicula("Venon","Miedo","Director",7.8,"","https://es.web.img3.acsta.net/c_310_420/pictures/21/08/31/16/41/4145554.jpg"),
            Pelicula("Avatar","Miedo","Director",7.8,"","https://es.web.img3.acsta.net/c_310_420/pictures/21/08/31/16/41/4145554.jpg"),
            Pelicula("Titulo de Pelicula","Miedo","Director",7.8,"","https://es.web.img3.acsta.net/c_310_420/pictures/21/08/31/16/41/4145554.jpg"),
            Pelicula("Titulo de Pelicula","Miedo","Director",7.8,"","https://es.web.img3.acsta.net/c_310_420/pictures/21/08/31/16/41/4145554.jpg")
    )
}