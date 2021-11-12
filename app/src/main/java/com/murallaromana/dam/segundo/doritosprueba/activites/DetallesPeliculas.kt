package com.murallaromana.dam.segundo.doritosprueba.activites

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.murallaromana.dam.segundo.doritosprueba.R
import com.murallaromana.dam.segundo.doritosprueba.databinding.ActivityDetallesPeliculasBinding
import com.murallaromana.dam.segundo.doritosprueba.databinding.PeliculasActivityBinding
import com.murallaromana.dam.segundo.doritosprueba.model.entidades.Pelicula
import com.squareup.picasso.Picasso

class DetallesPeliculas : AppCompatActivity() {
    private lateinit var binding: ActivityDetallesPeliculasBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetallesPeliculasBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val pelicula = intent.extras?.get("pelicula") as Pelicula
        binding.tvDetalleTitulo.setText(pelicula.titulo)
        Picasso.get().load(pelicula.URL).into(binding.ivDetallePelicula)
    }
}