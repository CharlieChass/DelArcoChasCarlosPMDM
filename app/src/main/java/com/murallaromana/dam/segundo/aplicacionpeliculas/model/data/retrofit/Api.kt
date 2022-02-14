package com.murallaromana.dam.segundo.aplicacionpeliculas.model.data.retrofit


import com.murallaromana.dam.segundo.aplicacionpeliculas.model.entidades.Pelicula
import com.murallaromana.dam.segundo.aplicacionpeliculas.model.entidades.Token
import com.murallaromana.dam.segundo.aplicacionpeliculas.model.entidades.Usuario
import retrofit2.Call
import retrofit2.http.*

interface Api {
    @GET("movies")
    fun getPeliculas(@Header("Authorization") token: String?): Call<List<Pelicula>>


    @POST("users/signup")
    fun signup(@Body usuario: Usuario): Call<Usuario>

    @POST("users/login")
    fun login(@Body usuario: Usuario): Call<Token>

    @GET("movies/{id}")
    fun getById(@Header("Authorization") token: String?,
                @Path("id") id: String?
               ): Call<Pelicula>

    @DELETE("movies/{id}")
    fun delete(@Header("Authorization")token: String?,
               @Path("id") id:String?): Call<Pelicula>

    @POST("movies")
    fun crear(@Header("Authorization") token:String,
                @Body pelicula: Pelicula): Call<Pelicula>

    @PUT("movies")
    fun editar(@Header("Authorization") token:String,
                @Body pelicula: Pelicula): Call<Pelicula>
}