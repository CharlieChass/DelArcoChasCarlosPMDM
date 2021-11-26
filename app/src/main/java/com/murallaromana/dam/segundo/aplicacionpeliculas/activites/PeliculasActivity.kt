package com.murallaromana.dam.segundo.aplicacionpeliculas.activites

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.murallaromana.dam.segundo.aplicacionpeliculas.App
import com.murallaromana.dam.segundo.aplicacionpeliculas.adapters.ListaPeliculasAdapter
import com.murallaromana.dam.segundo.aplicacionpeliculas.databinding.PeliculasActivityBinding
import com.murallaromana.dam.segundo.aplicacionpeliculas.model.data.PeliculasDataMockImpl

class PeliculasActivity :AppCompatActivity() {
    private lateinit var binding: PeliculasActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = PeliculasActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.fabAAdir.setOnClickListener(){
            val intent = Intent(this, AddPeliculaActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onResume() {
        super.onResume()
        val layoutManager = LinearLayoutManager(this)
        val listapeliculas = App.peliculas
        val adapter = ListaPeliculasAdapter(listapeliculas,this)
        binding.rvPeliculas.adapter = adapter
        binding.rvPeliculas.layoutManager = layoutManager

    }
}