package com.murallaromana.dam.segundo.aplicacionpeliculas.model.data.retrofit


import com.murallaromana.dam.segundo.aplicacionpeliculas.model.entidades.Pelicula
import com.murallaromana.dam.segundo.aplicacionpeliculas.model.entidades.Token
import com.murallaromana.dam.segundo.aplicacionpeliculas.model.entidades.Usuario
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

interface Api {
    @GET("movies")
    fun getPeliculas(@Header("Authorization") token: String?): Call<List<Pelicula>>



    @POST("users/signup")
    fun signup(@Body usuario: Usuario): Call<Usuario>

    @POST("users/login")
    fun login(@Body usuario: Usuario): Call<Token>

}