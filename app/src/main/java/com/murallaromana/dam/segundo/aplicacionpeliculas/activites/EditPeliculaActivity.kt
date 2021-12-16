package com.murallaromana.dam.segundo.aplicacionpeliculas.activites

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.murallaromana.dam.segundo.aplicacionpeliculas.databinding.ActivityEditPeliculaBinding
import com.murallaromana.dam.segundo.aplicacionpeliculas.model.entidades.Pelicula

class EditPeliculaActivity : AppCompatActivity() {
    private lateinit var binding: ActivityEditPeliculaBinding

    companion object {
        lateinit var pelicula: Pelicula
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditPeliculaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        pelicula = intent.extras?.get("pelicula") as Pelicula

        binding.TieTitulo.setText(pelicula.titulo)
        binding.TieDirector.setText(pelicula.director)
        binding.TieGenero.setText(pelicula.genero)
        binding.TieNumeroDirector.setText(pelicula.telefonoDirector)
        binding.TiePuntuacion.setText(pelicula.nota.toString())
        binding.TieURL.setText(pelicula.URL)
        binding.TieResumen.setText(pelicula.resumen)
    }


}