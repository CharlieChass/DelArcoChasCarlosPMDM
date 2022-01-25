package com.murallaromana.dam.segundo.aplicacionpeliculas.model.data.retrofit

import com.murallaromana.dam.segundo.aplicacionpeliculas.model.entidades.Pelicula
import retrofit2.Call
import retrofit2.http.GET

interface Api {
    @GET("movies")
    fun getPeliculas(): Call<List<Pelicula>>

    // TODO declarar todos los metodos del Api
    //

}