package com.murallaromana.dam.segundo.aplicacionpeliculas.activites

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.murallaromana.dam.segundo.aplicacionpeliculas.App
import com.murallaromana.dam.segundo.aplicacionpeliculas.RetrofitClient
import com.murallaromana.dam.segundo.aplicacionpeliculas.adapters.ListaPeliculasAdapter
import com.murallaromana.dam.segundo.aplicacionpeliculas.databinding.PeliculasActivityBinding
import com.murallaromana.dam.segundo.aplicacionpeliculas.model.entidades.Pelicula
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PeliculasActivity : AppCompatActivity() {
    private lateinit var binding: PeliculasActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = PeliculasActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val context = this

        binding.fabAAdir.setOnClickListener() {
            val intent = Intent(this, AddPeliculaActivity::class.java)
            startActivity(intent)
        }
        //CONFIGURAR API-RETROFIT
        val llamadaApi: Call<List<Pelicula>> = RetrofitClient.apiRetrofit.getPeliculas()
        llamadaApi.enqueue(object : Callback<List<Pelicula>>{
            override fun onResponse(call: Call<List<Pelicula>>, response: Response<List<Pelicula>>) {
               Toast.makeText(context,response.body().toString(),Toast.LENGTH_SHORT).show()
            }
            override fun onFailure(call: Call<List<Pelicula>>, t: Throwable) {
                Log.d("Prueba", t.message.toString())
            }

        })
    }





    override fun onResume() {
        super.onResume()
        val layoutManager = LinearLayoutManager(this)
        val listapeliculas = App.peliculas
        val adapter = ListaPeliculasAdapter(listapeliculas, this)
        binding.rvPeliculas.adapter = adapter
        binding.rvPeliculas.layoutManager = layoutManager

    }

    override fun onBackPressed() {
        val a = Intent(Intent.ACTION_MAIN)
        a.addCategory(Intent.CATEGORY_HOME)
        a.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        startActivity(a)
    }
}