package com.murallaromana.dam.segundo.aplicacionpeliculas.model.data

import com.murallaromana.dam.segundo.aplicacionpeliculas.model.entidades.Pelicula
import java.util.*
import kotlin.collections.ArrayList

 open class PeliculasDataMockImpl : PeliculasData {
    override fun getTodos() = mutableListOf(
                    Pelicula(
                        "Venon",
                        "Acción",
                        "Ruben Fleischer",
                        7.8,
                        "698745213",
                        "https://es.web.img3.acsta.net/c_310_420/pictures/21/08/31/16/41/4145554.jpg"
                    ),
                    Pelicula(
                        "Avatar",
                        "Miedo",
                        "Director",
                        7.8,
                        "",
                        "https://es.web.img3.acsta.net/c_310_420/pictures/21/08/31/16/41/4145554.jpg"
                    ),
                    Pelicula(
                        "Titulo de Pelicula",
                        "Miedo",
                        "Director",
                        7.8,
                        "",
                        "https://es.web.img3.acsta.net/c_310_420/pictures/21/08/31/16/41/4145554.jpg"
                    ),
                    Pelicula(
                        "Titulo de Pelicula",
                        "Miedo",
                        "Director",
                        7.8,
                        "",
                        "https://es.web.img3.acsta.net/c_310_420/pictures/21/08/31/16/41/4145554.jpg"
                    )
    )
}