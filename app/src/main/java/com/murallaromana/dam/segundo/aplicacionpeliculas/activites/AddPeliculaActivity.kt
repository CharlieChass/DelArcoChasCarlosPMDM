package com.murallaromana.dam.segundo.aplicacionpeliculas.activites

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.murallaromana.dam.segundo.aplicacionpeliculas.databinding.ActivityAddPeliculaBinding
import com.murallaromana.dam.segundo.aplicacionpeliculas.model.entidades.Pelicula


class AddPeliculaActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAddPeliculaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddPeliculaBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}






