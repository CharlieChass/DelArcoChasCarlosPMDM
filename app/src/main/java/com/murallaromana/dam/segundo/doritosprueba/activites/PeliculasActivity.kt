package com.murallaromana.dam.segundo.doritosprueba.activites

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.murallaromana.dam.segundo.doritosprueba.adapters.ListaPeliculasAdapter
import com.murallaromana.dam.segundo.doritosprueba.databinding.PeliculasActivityBinding
import com.murallaromana.dam.segundo.doritosprueba.model.data.PeliculasDataMockImpl

class PeliculasActivity :AppCompatActivity() {
    private lateinit var binding: PeliculasActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = PeliculasActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val peliculasData = PeliculasDataMockImpl()
        val listaPeliculas = peliculasData.getTodos()

        val layoutManager = LinearLayoutManager(this)
        val adapter = ListaPeliculasAdapter(listaPeliculas,this)

        binding.rvPeliculas.adapter = adapter
        binding.rvPeliculas.layoutManager = layoutManager
    }
}