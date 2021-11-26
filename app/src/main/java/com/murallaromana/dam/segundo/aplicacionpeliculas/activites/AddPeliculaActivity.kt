package com.murallaromana.dam.segundo.aplicacionpeliculas.activites

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.murallaromana.dam.segundo.aplicacionpeliculas.App
import com.murallaromana.dam.segundo.aplicacionpeliculas.R
import com.murallaromana.dam.segundo.aplicacionpeliculas.databinding.ActivityAddPeliculaBinding
import com.murallaromana.dam.segundo.aplicacionpeliculas.model.data.PeliculasDataMockImpl
import com.murallaromana.dam.segundo.aplicacionpeliculas.model.entidades.Pelicula

class AddPeliculaActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAddPeliculaBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddPeliculaBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.btAAdirPelicula.setOnClickListener() {
            if (binding.TieTitulo == null) {
                Toast.makeText(this, "Rellena Titulo", Toast.LENGTH_SHORT).show()
            } else {
                App.peliculas.add(
                    Pelicula(
                        binding.TieTitulo.text.toString(),
                        binding.TieGenero.text.toString(),
                        binding.TieDirector.text.toString(),
                        binding.TiePuntuacion.text.toString().toDouble(),
                        binding.TieNumeroDirector.text.toString(),
                        binding.TieURL.text.toString()
                )
                )
                Toast.makeText(this,"Pelicula Añadida",Toast.LENGTH_SHORT).show()
                finish()
            }
        }
    }
}